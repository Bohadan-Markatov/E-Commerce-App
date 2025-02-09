package com.markatov.product.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequestDto {
    @NotBlank(message = "Product name cannot be blank")
    @Size(max = 100, message = "Product name must not exceed 100 characters")
    private String name;
    @NotBlank(message = "Description cannot be blank")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;
    @NotNull(message = "Quantity is required")
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Long quantity;
    @NotNull(message = "Category id is required")
    private Long categoryId;
    @NotNull(message = "Brand id is required")
    private Long brandId;
    @NotNull(message = "Country id is required")
    private Long countryId;
    @NotEmpty(message = "At least one image is required")
    private List<@NotNull(message = "Image file cannot be null") MultipartFile> images;
}
