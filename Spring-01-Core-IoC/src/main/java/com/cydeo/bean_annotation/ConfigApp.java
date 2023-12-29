package com.cydeo.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration

public class ConfigApp {

    @Bean
    FullTimeMentor fullTimeMentor(){
        return new FullTimeMentor();
    }

   // @Bean(name = "p1")
   @Bean
    @Primary
    PartTimeMentor partTimeMentor(){
        System.out.println("returned primary");
        return new PartTimeMentor();
    }

    @Bean
    //@Bean(name = "p2") //I gave names to do my beans
    PartTimeMentor partTimeMentor2(){
        return new PartTimeMentor();
    }

}
