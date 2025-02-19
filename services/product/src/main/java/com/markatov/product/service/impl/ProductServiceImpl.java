package com.markatov.product.service.impl;

import com.markatov.product.dto.product.ProductFullResponseDto;
import com.markatov.product.dto.product.ProductRequestDto;
import com.markatov.product.dto.product.ProductShortResponseDto;
import com.markatov.product.mapper.ProductMapper;
import com.markatov.product.model.Product;
import com.markatov.product.repository.ProductRepository;
import com.markatov.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public void saveProduct(ProductRequestDto dto) {
        productRepository.save(productMapper.toModel(dto));
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Could not find product with id " + id));
    }

    @Override
    public ProductFullResponseDto getProductDto(Long id) {
        return productMapper.toFullResponse(productRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Could not find product with id " + id)));
    }

    @Override
    public List<ProductShortResponseDto> getAllByCategory(String category) {
        return productRepository.findAllByCategory_Name(category).stream()
                .map(productMapper::toShortResponse)
                .toList();
    }
}
