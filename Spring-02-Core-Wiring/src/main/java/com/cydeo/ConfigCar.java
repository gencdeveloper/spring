package com.cydeo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {

    @Bean
    Car car(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    //Direct Wiring
//    @Bean
//    Person person(){
//        Person p = new Person();
//        p.setName("Mike");
//        p.setCar(car()); //This is direct wiring, call method annoted method @bean
//        return p;
//    }

    @Bean
    Person person(Car car){//This is AutoWiring,
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car());
        return p;
    }
}
