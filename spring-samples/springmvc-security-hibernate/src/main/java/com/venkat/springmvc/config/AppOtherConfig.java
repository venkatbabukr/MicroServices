package com.venkat.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.venkat.springmvc.app.services", "com.venkat.springmvc.app.dao" })
public class AppOtherConfig {

}
