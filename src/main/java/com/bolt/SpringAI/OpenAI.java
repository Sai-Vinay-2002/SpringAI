package com.bolt.SpringAI;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        return "index";
    }

    @GetMapping("/prompt/{message}")
    public ModelAndView promptAnswer(@PathVariable String message, ModelAndView mv)
    {
        String response=chatModel.call(message);

        mv.addObject("response",response);
        mv.setViewName("response");
        return mv;
    }
}
