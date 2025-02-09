package com.markatov.product.mapper;

import com.markatov.product.dto.ProductRequestDto;
import com.markatov.product.dto.ProductShortResponseDto;
import com.markatov.product.model.Image;
import com.markatov.product.model.Product;
import com.markatov.product.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final CountryService countryService;
    private final ImageService imageService;
    private final ProductService productService;
    private final CommentService commentService;

    public Product toModel(ProductRequestDto dto) {
        return Product.builder().name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .availableQuantity(dto.getQuantity())
                .category(categoryService.findCategoryById(dto.getCategoryId()))
                .brand(brandService.findBrandById(dto.getBrandId()))
                .country(countryService.findCountryById(dto.getCountryId()))
                .images(storeImagesAndGetIds(dto.getImages()))
                .build();
    }

    public ProductShortResponseDto toShortResponse(Product product) {
        var dto = new ProductShortResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setGrade(commentService.findAverageGradeByProductId(product.getId()));
        dto.setCoverImage(imageService
                .getImage(product
                .getImages()
                .getFirst())
                .getImage());
        return dto;
    }

    private List<String> storeImagesAndGetIds(List<MultipartFile> files) {
       return files.stream()
               .map(file -> {
                   var image = new Image();
                   image.setImage(getImageBytes(file));
                   return imageService.saveImage(image);
               }).toList();
    }

    private byte[] getImageBytes(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (Exception e) {
            throw new RuntimeException("Could not get image bytes"
                    + e.getMessage());
        }
    }
}
