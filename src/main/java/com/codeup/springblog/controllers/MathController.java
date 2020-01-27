package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/math/{string1}/{value1}/{string2}/{value2}")
    @ResponseBody
    public String mathFunction(@PathVariable String string1,@PathVariable String value1,@PathVariable String string2,@PathVariable String value2){
        int val1 = Integer.parseInt(value1);
        int val2 = Integer.parseInt(value2);
        if (string1.equalsIgnoreCase("add")){
            if (string2.equalsIgnoreCase("and")){
                return String.valueOf(val1+val2);
            }else {
                return "error";
            }
        }else if (string1.equalsIgnoreCase("subtract")){
            if (string2.equalsIgnoreCase("from")){
                return String.valueOf(val2-val1);
            }else if (string2.equalsIgnoreCase("by")){
                return String.valueOf(val1-val1);
            }else {
                return "error";
            }
        }else if (string1.equalsIgnoreCase("multiply")) {
            if (string2.equalsIgnoreCase("and")) {
                return String.valueOf(val1 * val2);
            } else {
                return "error";
            }
        }else if (string1.equalsIgnoreCase("divide")){
            if (string2.equalsIgnoreCase("from")){
                return String.valueOf(val2/val1);
            }else if (string2.equalsIgnoreCase("by")){
                return String.valueOf(val1/val2);
            }else {
                return "error";
            }
        }else {
            return "error";
        }
    }
}
