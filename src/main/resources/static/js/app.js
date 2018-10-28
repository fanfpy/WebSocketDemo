var $$ = mdui.JQ;

var ws;
/**
 * 开始聊天
 */
var data = {
    sendUser:null,
    toUser:null,
    message:null
};

var inst = new mdui.Dialog('#single-chat', {
    modal: true
});

function show_signle_dialog() {
    var nick_name = $('#nick_name').val();
    console.log(nick_name)
    if (nick_name === '') {
        $('#nick_name').focus();
        mdui.snackbar({
            message: '请输入一个昵称'
        });
        return;
    }
    data.sendUser = nick_name;
    data.toUser = $("#to_user_nick_name").val();
    inst.open();
    $('#chat_addr').attr("value",'ws://192.168.43.29:8080/channel/test/'+nick_name)

    new_websocket()
}

/**
 * 关闭聊天室
 */
function close_dialog() {
    $('#chat_msg').val('');
    mine_id = null, to_id = null;
    setTimeout(function () {
        $('.mdui-dialog-content .chat-body').html('<p class="mdui-m-b-3"><span class="chat-box-info"></span></p>');
    }, 180);
}

/**
 * 发送消息
 */
function send_msg() {
    var msg = $('#chat_msg').val();
    data.message = $('#chat_msg').val();
    var jsonString = JSON.stringify(data);
    console.log(jsonString)
    ws.send(jsonString);
    var html = '<p class="mdui-m-b-3"><span class="chat-box-pink">我 : '+ msg +'</span></p>';
    $('.mdui-dialog-content .chat-body').append(html);
    $('.mdui-dialog-content .chat-body').scrollTop($('.mdui-dialog-content .chat-body').height());
    $('#chat_msg').val('');
    $('#chat_msg').focus();
}

function new_websocket() {
    var chat_addr = $('#chat_addr').val();
    ws = new WebSocket(chat_addr);
    console.log(chat_addr)
    if(ws){

        ws.onopen = function () {
            // 使用 send() 方法发送数据
            console.log("连接成功")
        };

        // 接收聊天消息
        ws.onmessage = function(e){
            console.log("收到消息"+JSON.parse(e));
            var html = '<p class="mdui-m-b-3"><span class="chat-box-green">' + e.data + '</span></p>';
            $('.mdui-dialog-content .chat-body').append(html);
            $('.mdui-dialog-content .chat-body').scrollTop($('.mdui-dialog-content .chat-body').height());
        };
    }
}