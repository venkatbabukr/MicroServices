package com.venkat.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan("com.venkat.springmvc.app.controllers")
public class AppMvcConfig implements WebMvcConfigurer {

}
