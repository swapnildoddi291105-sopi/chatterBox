package com.example.firstdemo.controller;


import com.example.firstdemo.model.ChatMsg;
import com.example.firstdemo.model.Message;
import com.example.firstdemo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HelloController {

    private final MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMsg sendMsg(ChatMsg msg1){
        Message msg=new Message();
        msg.setSender(msg1.getSender());
        msg.setMsg(msg1.getMsg());
        msg.setType(msg1.getType());
        messageService.saveMsg(msg);
        return msg1;
    }

    @MessageMapping("/addUser")
    @SendTo("/topic/messages")
    public ChatMsg addUser(ChatMsg msg){
        msg.setType(ChatMsg.MessageType.JOIN);
        return msg;
    }

    @GetMapping("/messages")
    @ResponseBody
    public List<Message> getMsg()
    {
        return messageService.getAllMsg();
    }
}