package com.markatov.product.dto.product;

import com.markatov.product.dto.image.ImageResponseDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductShortResponseDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Double grade;
    private ImageResponseDto coverImage;
}
