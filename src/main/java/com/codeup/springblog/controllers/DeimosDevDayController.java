package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeimosDevDayController {

    @GetMapping("/deimos")
    @ResponseBody
    public String devDay(){
        return "There are 31 days til Developer Day!";
    }


    @GetMapping("/deimos/{daysLeft}")
    @ResponseBody
    public String devDay(@PathVariable String daysLeft){
        return "There are " + daysLeft + " days til Developer Day!";
    }
}
