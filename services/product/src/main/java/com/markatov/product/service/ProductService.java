package com.markatov.product.service;

import com.markatov.product.dto.product.ProductFullResponseDto;
import com.markatov.product.dto.product.ProductRequestDto;
import com.markatov.product.dto.product.ProductShortResponseDto;
import com.markatov.product.model.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductRequestDto dto);

    Product getProduct(Long id);

    ProductFullResponseDto getProductDto(Long id);

    List<ProductShortResponseDto> getAllByCategory(String category);
}
