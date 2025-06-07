package vn.trandoananh.SpringBoot_Blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.trandoananh.SpringBoot_Blog.entity.Category;
import vn.trandoananh.SpringBoot_Blog.repository.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }

    @GetMapping("/create")
    public String form(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id).orElseThrow();
        model.addAttribute("category", category);
        return "category-edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }
}
