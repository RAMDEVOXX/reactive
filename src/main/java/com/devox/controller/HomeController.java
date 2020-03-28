package com.devox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  @EnableAutoConfiguration
@RestController
@RefreshScope
@RequestMapping("/home")
public class HomeController {

    @Value("${static.message:staticMessage}")
    private String staticMessage;

    @Value("${reload.client.version}")
    private String dynamiqueMessage;

    @Autowired
    private Environment environment;

    @GetMapping
    public String home() {
        return "static Message :" + staticMessage.concat(
                "  Dynamique Message : " + dynamiqueMessage);
    }

    @GetMapping("/details")
    public String environmentDetails() {
        return environment.toString();
    }


}
