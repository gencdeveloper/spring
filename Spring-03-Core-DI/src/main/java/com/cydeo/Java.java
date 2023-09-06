package com.cydeo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java {

    //Field Injection
    //    @Autowired
    //    OfficeHours officeHours;



    OfficeHours officeHours;

    //Constructor Injection
//    @Autowired
    /** if you have a spring version bigger than 4.3, when created constructor it will create @Autowired as a default*/
    //Also, if you define lombok @AllConstructor annotation, that time no need to create manuel constructor,
    // spring will understood and it will create @Autowiring
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
    public void getTeachingHours(){
        System.out.println("Weekly teaching hours: " + (20 + officeHours.getHours()));
    }
}
