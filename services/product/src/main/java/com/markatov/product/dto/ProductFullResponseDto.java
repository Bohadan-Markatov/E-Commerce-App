package com.markatov.product.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductFullResponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String categoryName;
    private String brandName;
    private String countryName;
    private Double grade;
    private List<byte[]> images;
}
