package com.devox.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="dynamique")
//@PropertySource("classpath:static/application.yml")
public class PropertiesConfiguration {


}
