package com.markatov.product.mapper;

import com.markatov.product.dto.brand.BrandResponseDto;
import com.markatov.product.model.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandMapper {

    public BrandResponseDto toBrandResponseDto(Brand brand) {
        var response = new BrandResponseDto();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }
}
