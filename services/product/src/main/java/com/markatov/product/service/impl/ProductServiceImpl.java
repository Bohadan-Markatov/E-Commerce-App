package com.markatov.product.service.impl;

import com.markatov.product.repository.ProductRepository;
import com.markatov.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


}
