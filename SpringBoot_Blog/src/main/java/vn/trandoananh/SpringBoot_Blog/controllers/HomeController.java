package vn.trandoananh.SpringBoot_Blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
    public String home() {
        return "index"; // trỏ tới index.html
    }
}
