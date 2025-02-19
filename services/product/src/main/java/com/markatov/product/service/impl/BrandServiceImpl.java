package com.markatov.product.service.impl;

import com.markatov.product.dto.brand.BrandResponseDto;
import com.markatov.product.mapper.BrandMapper;
import com.markatov.product.model.Brand;
import com.markatov.product.repository.BrandRepository;
import com.markatov.product.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cannot find brand with id: " + id));
    }

    @Override
    public List<BrandResponseDto> findAllBrands() {
        return brandRepository.findAll().stream()
                .map(brandMapper::toBrandResponseDto)
                .toList();
    }
}
