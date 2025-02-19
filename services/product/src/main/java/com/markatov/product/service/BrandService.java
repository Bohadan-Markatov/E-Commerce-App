package com.markatov.product.service;

import com.markatov.product.dto.brand.BrandResponseDto;
import com.markatov.product.model.Brand;

import java.util.List;

public interface BrandService {

    void save(Brand brand);

    Brand findBrandById(Long id);

    List<BrandResponseDto> findAllBrands();
}
