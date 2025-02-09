package com.markatov.product.service.impl;

import com.markatov.product.model.Category;
import com.markatov.product.repository.CategoryRepository;
import com.markatov.product.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cannot find Category with id: " + id));
    }
}
