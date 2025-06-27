package com.bolt.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OpenAI {
    private ChatClient chatClient;

    public OpenAI(ChatClient.Builder builder)
    {
        this.chatClient=builder.build() ;
    }

    @GetMapping("/")
    public String homepage()
    {
        return "index";
    }

    @GetMapping("/prompt/{message}")
    public ModelAndView promptAnswer(@PathVariable String message, ModelAndView mv)
    {
        ChatResponse chatResponse=chatClient
                .prompt(message)
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response=chatResponse
                .getResult()
                .getOutput()
                .getText();

        mv.addObject("response",response);
        mv.setViewName("response");
        return mv;
    }
}
