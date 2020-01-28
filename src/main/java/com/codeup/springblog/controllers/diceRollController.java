package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class diceRollController {

    @GetMapping("/roll-dice")
    public String guessDice(){
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String checkRoll(@RequestParam(name = "guessNumber") int num, Model model){
        int answer = (int)(Math.random()*6) +1;
        boolean numMatch = false;
        if (answer == num){
            numMatch = true;
        }
        model.addAttribute("random", answer);
        model.addAttribute("guess",num);
        model.addAttribute("numMatch",num);
        return "roll-dice";
    }


}
