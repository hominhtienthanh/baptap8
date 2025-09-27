package baitap8.Thymeleaf.service;

import baitap8.Thymeleaf.entity.Category;
import baitap8.Thymeleaf.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Page<Category> listAll(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        if (keyword != null && !keyword.isEmpty()) {
            return repo.findByNameContainingIgnoreCase(keyword, pageable);
        }
        return repo.findAll(pageable);
    }

    public Category save(Category category) {
        return repo.save(category);
    }

    public Category get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}