package com.example.firstdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMsg {


    private String sender;
    private String msg;
    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }


}
