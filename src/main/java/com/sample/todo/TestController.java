package com.sample.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/todo")
public class TestController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("message","hello world");
        return "home";
    }
}
