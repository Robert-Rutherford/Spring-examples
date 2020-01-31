package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao,UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
    public String indexAction(@RequestParam(name = "editPostBtn") boolean editPressed, Model model){

        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
//        Post post1 = new Post(id,"Title 1","description 1");
        Post editPost = postDao.findById(id);
        model.addAttribute("id",editPost.getId());
        model.addAttribute("title", editPost.getTitle());
        model.addAttribute("body",editPost.getBody());
        User editUser = userDao.findByPosts(editPost);
        model.addAttribute("email", editUser.getEmail());
//        model.addAttribute("post", post1);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostPage(Model model){
        model.addAttribute("newPost", new Post());
        return "/posts/create";
    }

//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam String title, @RequestParam String body) {
//        long idTemp = 2;
//        User userCheck = userDao.findById(idTemp);
//
//        Post post = new Post(
//            title,
//            body,
//            userCheck
//    );
//        postDao.save(post);
//        return "redirect:/posts";
//    }
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute(name = "newPost") Post post) {
        User userTemp = userDao.findById(1);
        post.setUser(userTemp);
        postDao.save(post);
        return "redirect:/posts";
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
    {
        User tempUser = userDao.findById(1);
        Post post = new Post(
                id,
                title,
                body,
                tempUser
        );
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/one/test")
    public String oneToOneTest(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "one-to-one-test";
    }

//    @GetMapping("/oneMany/test")
//    public String oneToMany(Model model){
//        model.addAttribute("posts", postDao.findAll());
//        return "one-to-many-test";
//    }


}
