package com.markatov.product.service;

import com.markatov.product.dto.category.CategoryResponseDto;
import com.markatov.product.model.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    Category findCategoryById(Long id);

    List<CategoryResponseDto> getAll();
}
