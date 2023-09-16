package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info") //localhost:8080/car/info?make=volvo&year=2018
    public String carInfo(@RequestParam String make,@RequestParam Integer year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);
        System.out.println(make);
        return "car/car-info";
    }

    //request parameter match with key
    @RequestMapping("/info2") //if you try to just localhost:8080/car/info2 it will show as a defaultValue
    public String carInfo2(@RequestParam(value = "make",required = false,defaultValue = "Tesla") String make, Model model){

        model.addAttribute("make",make);
        System.out.println(make);
        return "car/car-info";
    }

    @RequestMapping("/info/{make}/{year}") //localhost:8080/car/info/honda --> it coming dynamic way with PathVariable,
    public String getCarInfo(@PathVariable String make,@PathVariable Integer year, Model model){
        model.addAttribute("make",make);
        model.addAttribute("year",year);
        return "car/car-info";
    }
}
