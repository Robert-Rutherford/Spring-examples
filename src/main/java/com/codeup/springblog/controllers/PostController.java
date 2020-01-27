package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String indexPage(){
        return "this is index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable String id){
        return "view an individual post of id: "+id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostPage(){
        return "view the form for creating a post...";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Creating new post...";
    }


}
