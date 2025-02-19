package com.markatov.product.repository;

import com.markatov.product.dto.product.ProductShortResponseDto;
import com.markatov.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory_Name(String category);
}
