package vn.trandoananh.SpringBoot_Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.trandoananh.SpringBoot_Blog.entity.Category;
import vn.trandoananh.SpringBoot_Blog.entity.Post;
import vn.trandoananh.SpringBoot_Blog.repository.CategoryRepository;
import vn.trandoananh.SpringBoot_Blog.repository.PostRepository;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts";
    }

    @GetMapping("/create")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryRepository.findAll());
        return "post-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("post") Post post, @RequestParam("categoryId") Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        post.setCategory(category);
        postRepository.save(post);
        return "redirect:/posts";
    }
}
