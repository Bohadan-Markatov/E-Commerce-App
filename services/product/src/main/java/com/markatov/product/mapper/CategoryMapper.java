package com.markatov.product.mapper;

import com.markatov.product.dto.category.CategoryResponseDto;
import com.markatov.product.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryResponseDto toCategoryResponseDto(Category category) {
        var responseDto = new CategoryResponseDto();
        responseDto.setId(category.getId());
        responseDto.setName(category.getName());
        return responseDto;
    }
}
