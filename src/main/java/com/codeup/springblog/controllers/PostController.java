package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String postsIndex(Model model){
//        ArrayList<Post> postList = new ArrayList<Post>();
//        postList.add(new Post(2, "Title 2", "Description 2"));
//        postList.add(new Post(3, "Title 3", "Description 3"));
        List<Post> postList = postDao.findAll();
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @PostMapping("/posts")
    public String indexAction(@PathVariable(name = "hiddenId") String id, Model model){

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
//        Post post1 = new Post(id,"Title 1","description 1");
        Post editPost = postDao.findById(id);
        model.addAttribute("id",editPost.getId());
        model.addAttribute("title", editPost.getTitle());
        model.addAttribute("body",editPost.getBody());
//        model.addAttribute("post", post1);

        return "posts/show";
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

    @PostMapping("posts/{id}/delete")
    public String deletePost(@PathVariable long id) {

        postDao.deleteById(id);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String viewEditPage(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body)
    {    Post post = new Post(
                id,
                title,
                body
        );
        postDao.save(post);
        return "redirect:/posts";
    }


}
