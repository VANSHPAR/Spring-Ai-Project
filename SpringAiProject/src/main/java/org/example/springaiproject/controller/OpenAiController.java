package org.example.springaiproject.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAiController {

    private OpenAiChatModel openAiChatModel;
    public OpenAiController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }
    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        String response=openAiChatModel.call(message);
        return ResponseEntity.ok(response);
    }
}
