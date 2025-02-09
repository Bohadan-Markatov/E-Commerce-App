package com.markatov.product.service.impl;

import com.markatov.product.model.Brand;
import com.markatov.product.repository.BrandRepository;
import com.markatov.product.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public Brand findBrandById(Long id) {
        return brandRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Cannot find brand with id: " + id));
    }
}
