package com.bolt.SpringAI;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.image.ImageGeneration;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.image.ImageGeneration;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OpenAI {


    private final OpenAiChatModel chatModel;


    private final OpenAiImageModel imageModel;

    public OpenAI(OpenAiChatModel chatModel, OpenAiImageModel imageModel) throws CloneNotSupportedException {
        this.chatModel = chatModel;
        this.imageModel = imageModel;
    }


    @RequestMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/prompt")
    public ModelAndView promptAnswer(@RequestParam(required = false) String images, @RequestParam String message, ModelAndView mv) {

        if (images==null || !(images.equalsIgnoreCase("images"))) {

            String response = chatModel.call(message);
            mv.addObject("response", response);
        } else {
            ImagePrompt imagePrompt = new ImagePrompt(message);
            ImageResponse imageResponse = imageModel.call(imagePrompt);

            String imageUrl = imageResponse.getResults().get(0).getOutput().getUrl();
            mv.addObject("imageUrl", imageUrl);
        }


        mv.setViewName("index");
        return mv;
    }
}

