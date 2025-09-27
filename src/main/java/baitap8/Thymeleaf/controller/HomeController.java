package baitap8.Thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/baitap8")
    public String home() {
        return "index"; // trả về file index.html trong thư mục templates
    }
}
