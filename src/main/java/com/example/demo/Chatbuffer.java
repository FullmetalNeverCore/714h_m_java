package com.example; 
import java.io.*;
import java.util.stream.Collectors;

 
public class Chatbuffer{
    private String chatbuff;

    public Chatbuffer(String content) {
        this.chatbuff = content;
    }

    public String getChat() {
        return chatbuff;
    }

    public void setChat(String content) {
        this.chatbuff = content;
    }
}