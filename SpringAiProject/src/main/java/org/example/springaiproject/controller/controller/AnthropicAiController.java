package org.example.springaiproject.controller.controller;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicAiController {

    private ChatClient chatClient;


    public AnthropicAiController(AnthropicChatModel anthropicChatModel) {
        this.chatClient = ChatClient.create(anthropicChatModel);
    }


    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        String response=chatClient.prompt(message).call().content();
        return ResponseEntity.ok(response);
        //instead of using chatmodel we use chatclient because it gives metadata,more flexibility,more power,etc..
    }
}
