package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AdRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }


    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }
}
