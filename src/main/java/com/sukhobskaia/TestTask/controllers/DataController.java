package com.sukhobskaia.TestTask.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data")
@Controller
public class DataController {

    @GetMapping()
    public String getData() {
        return "data";
    }
}
