package baitap8.Thymeleaf.controller;

import baitap8.Thymeleaf.entity.Category;
import baitap8.Thymeleaf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Hiển thị danh sách categories
    @GetMapping("/baitap8/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories/list"; // trả về file list.html trong templates/categories
    }
}
