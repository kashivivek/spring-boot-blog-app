package org.martynas.blogapp.controller;

import org.martynas.blogapp.model.Post;
import org.martynas.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Collection;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = {"/newwebsite","/"}, method = RequestMethod.GET)
    public String displayAllPosts(Model model) {

        Collection<Post> posts = this.postService.getAll();
        model.addAttribute("posts", posts);

        return "home";
    }

}
