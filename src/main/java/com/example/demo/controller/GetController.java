package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class GetController {

    @RequestMapping(method = RequestMethod.GET, value = "example")
    public String getData(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("headers", headers);
        return "index";
    }

}
