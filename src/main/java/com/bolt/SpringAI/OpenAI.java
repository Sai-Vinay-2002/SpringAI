package com.bolt.SpringAI;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OpenAI {

//    private OpenAiChatModel chatModel;
//
//    public OpenAI(OpenAiChatModel chatModel)
//    {
//        this.chatModel=chatModel;
//    }

    @RequestMapping("/")
    public String homepage()
    {
        return "index";
    }

//    @GetMapping("/prompt/{message}")
//    public ModelAndView promptAnswer(@PathVariable String message, ModelAndView mv)
//    {
//
//        String response=chatModel.call(message);
//
//        mv.addObject("response",response);
//        mv.setViewName("response");
//        return mv;
//    }
}
