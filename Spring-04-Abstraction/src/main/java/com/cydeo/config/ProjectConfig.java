package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.cydeo") //it will check from under the decided packages
@ComponentScan(basePackages = {"com.cydeo.proxy","com.cydeo.service","com.cydeo.repository"}) //another way
public class ProjectConfig {
}
