package com.bolt.SpringAI;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAI {
    private OpenAiChatModel chatModel;

    public OpenAI(OpenAiChatModel chatModel)
    {
        this.chatModel=chatModel;
    }

    @GetMapping("/")
    public String homepage()
    {
        return "index.jsp";
    }

    @GetMapping()
    public String promptAnswer(@PathVariable String message)
    {
        String response=chatModel.call(message);

        return response;
    }
}
