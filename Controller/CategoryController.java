package com.example.pcmarket.Controller;

import com.example.pcmarket.Dto.CategoryDto;
import com.example.pcmarket.Model.Category;
import com.example.pcmarket.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.pcmarket.Result;

import java.util.List;
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> addCategoryC(@RequestBody CategoryDto category) {
        Result result = categoryService.addCategoryService(category);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> getCategory() {
        List<Category> categoryService1 = categoryService.getCategoryService();
        return ResponseEntity.ok(categoryService1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryId(@PathVariable Integer id) {
        Category categoryById = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Result result = categoryService.putCategory(id, categoryDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        Result result = categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
    }
}
