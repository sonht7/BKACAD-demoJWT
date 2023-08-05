package com.example.demoojwt2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
public String homePage(){
    return "This is Homepage";
}

}
