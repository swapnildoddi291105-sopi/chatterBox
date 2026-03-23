package com.example.firstdemo.service;

import com.example.firstdemo.model.Message;
import com.example.firstdemo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message saveMsg(Message message)
    {
        return messageRepository.save(message);
    }
    public List<Message> getAllMsg(){
        return messageRepository.findAll();
    }
}
