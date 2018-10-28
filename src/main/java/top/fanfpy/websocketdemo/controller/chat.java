package top.fanfpy.websocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fanfpy.websocketdemo.entity.Message;
import top.fanfpy.websocketdemo.service.impl.MessageServiceImpl;

@RestController
public class chat {

    @Autowired
    MessageServiceImpl messageService;

    @PostMapping(value = "/sendMessage")
    public Message sendMessage(Message message){
        return messageService.addMessage(message);
    }


}
