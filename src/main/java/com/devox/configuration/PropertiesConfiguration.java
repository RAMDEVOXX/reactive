package com.devox.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:reload/application-reload-configuration.properties")
@PropertySource("classpath:static/application-dev.properties")
public class PropertiesConfiguration {


}
