package top.fanfpy.websocketdemo.service;

import top.fanfpy.websocketdemo.entity.Message;

import java.util.List;

public interface MessageService {
    public Message addMessage(Message message);

    public void delMessage(Integer id);

    public List<List<Message>> messageList(Integer id);
}
