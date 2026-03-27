package com.example.chatbot;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class WebhookController {

    private static final Logger log = Logger.getLogger(WebhookController.class.getName());

    private static final Map<String, String> REPLIES = Map.of(
            "hi",          "Hello! How can I help you today?",
            "hello",       "Hello! How can I help you today?",
            "hey",         "Hello! How can I help you today?",
            "bye",         "Goodbye! Have a great day!",
            "goodbye",     "Goodbye! Have a great day!",
            "how are you", "I am just a bot, but I am doing great!",
            "help",        "You can say: Hi, Bye, How are you"
    );

    private static final String DEFAULT_REPLY = "Sorry, I did not understand. Type 'help' to see what I can do.";

    @PostMapping("/webhook")
    public BotResponse receiveMessage(@RequestBody Message message) {
        log.info("Message received from: " + message.getFrom() + " | Text: " + message.getText());

        String reply = REPLIES.getOrDefault(message.getText().toLowerCase().trim(), DEFAULT_REPLY);
        BotResponse response = new BotResponse(message.getFrom(), reply);

        log.info("Replying to: " + message.getFrom() + " | Reply: " + reply);
        return response;
    }
}