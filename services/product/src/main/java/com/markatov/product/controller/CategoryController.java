package com.markatov.product.controller;

import com.markatov.product.dto.category.CategoryResponseDto;
import com.markatov.product.model.Category;
import com.markatov.product.service.CategoryService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NotNull @NotEmpty String name) {
        var category = new Category();
        category.setName(name);
        categoryService.save(category);
    }

    @GetMapping("/all")
    public List<CategoryResponseDto> getAll() {
        return categoryService.getAll();
    }
}
