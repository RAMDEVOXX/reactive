package com.devox.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="dynamique")
@PropertySource("classpath:reload/application-reload-configuration.properties")
@PropertySource("classpath:static/application-dev.properties")
public class PropertiesConfiguration {


}
