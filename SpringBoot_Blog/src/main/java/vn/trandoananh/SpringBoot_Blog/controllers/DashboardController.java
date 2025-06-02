package vn.trandoananh.SpringBoot_Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.trandoananh.SpringBoot_Blog.repository.CategoryRepository;
import vn.trandoananh.SpringBoot_Blog.repository.PostRepository;

@Controller
public class DashboardController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("postCount", postRepository.count());
        model.addAttribute("categoryCount", categoryRepository.count());
        return "dashboard";
    }
}
