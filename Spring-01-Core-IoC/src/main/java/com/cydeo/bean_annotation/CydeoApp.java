package com.cydeo.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {
                                     //spring container concept
                                    //ConfigApp.class get inside whatever then Container will create
                                    //object instead of me. This is IOC(Inversion of controll)
        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);

        //PartTimeMentor pt = container.getBean("p1",PartTimeMentor.class);
        PartTimeMentor pt = container.getBean(PartTimeMentor.class); //if u use @Primary no need to specific name!

        ft.createAccount();
        pt.createAccount();

        String str = container.getBean(String.class);
        System.out.println(str);
    }
}
