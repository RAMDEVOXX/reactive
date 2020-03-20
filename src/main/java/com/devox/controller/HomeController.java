package com.devox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HomeController {

    @Value("${static.message:staticMessage}")
    private String staticMessage;

    @Value("${dynamique.message:dynamiqueMessage}")
    private String dynamiqueMessage;

    @Autowired
    private Environment environment;

    @GetMapping("/home")
    public String home() {
        return "static Message :" + staticMessage.concat(
                "  Dynamique Message : " + dynamiqueMessage);
    }

    @GetMapping("/details")
    public String environmentDetails() {
        return environment.toString();
    }


}
