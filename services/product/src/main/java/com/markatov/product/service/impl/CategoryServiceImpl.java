package com.markatov.product.service.impl;

import com.markatov.product.dto.category.CategoryResponseDto;
import com.markatov.product.mapper.CategoryMapper;
import com.markatov.product.model.Category;
import com.markatov.product.repository.CategoryRepository;
import com.markatov.product.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cannot find Category with id: " + id));
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponseDto)
                .toList();
    }
}
