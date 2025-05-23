package vn.trandoananh.SpringBoot_Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.trandoananh.SpringBoot_Blog.entity.User;
import vn.trandoananh.SpringBoot_Blog.repository.UserRepository;

@Controller
public class AuthController {
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute("user") User user) {
        // (bạn có thể mã hóa mật khẩu nếu muốn)
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}
