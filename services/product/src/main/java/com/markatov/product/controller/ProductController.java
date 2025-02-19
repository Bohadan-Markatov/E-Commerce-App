package com.markatov.product.controller;

import com.markatov.product.dto.product.ProductFullResponseDto;
import com.markatov.product.dto.product.ProductRequestDto;
import com.markatov.product.dto.product.ProductShortResponseDto;
import com.markatov.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @ModelAttribute ProductRequestDto productRequestDto) {
        productService.saveProduct(productRequestDto);
    }

    @GetMapping("/{id}")
    public ProductFullResponseDto get(@PathVariable Long id) {
        return productService.getProductDto(id);
    }

    @GetMapping("/{category}")
    public List<ProductShortResponseDto> getAllByCategory(@PathVariable String category) {
        return productService.getAllByCategory(category);
    }
}
