package top.fanfpy.websocketdemo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.fanfpy.websocketdemo.entity.Message;

@Component
@ServerEndpoint("/channel/test/{sendUser}")
public class WebSocketServer {

    // 用户在线数
    private static int onLineCount = 0;

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

    private Session session;

    private String sendUser;// 当前用户
    private String toUser;// 接收人
    private String message;// 聊天信息



    //实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key为用户标识

    private static Map<String,WebSocketServer> connections = new ConcurrentHashMap<>();

    private static ArrayList<Message> messageArrayList = new ArrayList<>();

    @OnMessage(maxMessageSize = 10)
    public void onMessage(String jsonString) throws IOException {
        System.out.println("来自客户端的消息"+jsonString);
        JSONObject json=JSONObject.parseObject(jsonString);
        sendUser = json.getString("sendUser");
        toUser = json.getString("toUser");
        message = json.getString("message");
        message = "{'sendUser':"+sendUser+",'toUser':"+toUser+",'message':"+message+"}";

        messageArrayList.add(new Message(sendUser,toUser,message,new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())));

        LOGGER.info("消息内容",message);
        WebSocketServer user = connections.get(toUser);
        //如果接收人不存在则保持到数据库
        if (user == null) {
            LOGGER.info("信息已保存到数据库");
            return;
        }
        user.sendMessage("send",message);
    }
    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig, @PathParam("parm") String parm) throws IOException {
        this.session = session;
        //初始化用户
        this.sendUser = parm;
        LOGGER.info("新的连接,用户id={}",parm);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount() + " 当前session是" + session.hashCode());
        connections.put(sendUser,this);
        for (WebSocketServer chat : connections.values()) {
            //使用if判断是要统计人数还是发送消息
            chat.sendMessage("count",getOnlineCount() + "");
        }
    }
    @OnClose
    public void onClose(CloseReason closeReason) throws IOException {
        LOGGER.info("连接断开,id={} reason={}",this.session.getId(),closeReason);
        // 在线数减1
        subOnlineCount();
        for (WebSocketServer chat : connections.values()) {
            if(chat.session != this.session){
                chat.sendMessage("count", getOnlineCount() + "");
            }
        }
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        if (getOnlineCount()==0){
            messageArrayList.forEach(System.out::println);
        }
    }
    @OnError
    public void onError(Throwable throwable) throws IOException {
        LOGGER.info("连接异常,id={},throwable={}",this.session.getId(),throwable);
        this.session.close();
        throwable.printStackTrace();
    }

    public void sendMessage(String type,String message) throws IOException {
        if("count".equals(type)){

            this.session.getBasicRemote().sendText("当前在线人数:" + message);
        }else {
            this.session.getBasicRemote().sendText(message);
        }
    }

    // 获得当前在线人数
    public static synchronized int getOnlineCount() {
        return onLineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocketServer.onLineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocketServer.onLineCount--;
    }
}
