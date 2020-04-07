package com.devox.reactive;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@SpringBootApplication(exclude={WebMvcAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//http://localhost:8085/swagger-ui.html#
@EnableSwagger2WebFlux
//http://localhost:8085/applications
@EnableAdminServer
@EnableDiscoveryClient
//Il faut s'assurer qu'il n'y ait pas des dépendences mvc (pom tree!=)
//il faut ajouter un @EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class }) dans la class de de Config
@EntityScan("com.devox.bean")
@ComponentScan(basePackages = {"com.devox"})
//@EnableWebFlux
public class ReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApplication.class, args);
    }

}
