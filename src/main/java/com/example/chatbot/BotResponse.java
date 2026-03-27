package com.example.chatbot;

public class BotResponse {
    private String to;
    private String reply;

    public BotResponse(String to, String reply) {
        this.to = to;
        this.reply = reply;
    }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }
}