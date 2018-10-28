package top.fanfpy.websocketdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fanfpy.websocketdemo.dao.MessageRepository;
import top.fanfpy.websocketdemo.entity.Message;
import top.fanfpy.websocketdemo.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delMessage(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public List<List<Message>> messageList(Integer id) {

        return null;
    }
}
