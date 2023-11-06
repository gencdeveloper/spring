package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")//class level endPoint
public class StudentController {

   // @RequestMapping(value = "/register", method = RequestMethod.GET) //returning your endPoint
    @GetMapping("/register")
    public String register(Model model){

    model.addAttribute("students", DataGenerator.createStudent());


        return "student/register"; //returning your html
    }


    @GetMapping("/welcome")
    public String info(){

        return "student/welcome";
    }
}
