package com.example; 
 
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