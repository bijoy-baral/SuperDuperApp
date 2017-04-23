package com.superdupper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Bijoy
 * @version 1.0 
 * Application configuration class and this is used to scan for the
 * package where REST implemenation resides.
 */
@Configuration
@ComponentScan("com.superdupper")
@EnableWebMvc
public class AppConfig {

}
