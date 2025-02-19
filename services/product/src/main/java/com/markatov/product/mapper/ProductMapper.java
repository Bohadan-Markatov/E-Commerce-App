package com.markatov.product.mapper;

import com.markatov.product.dto.image.ImageResponseDto;
import com.markatov.product.dto.product.ProductFullResponseDto;
import com.markatov.product.dto.product.ProductRequestDto;
import com.markatov.product.dto.product.ProductShortResponseDto;
import com.markatov.product.model.Image;
import com.markatov.product.model.Product;
import com.markatov.product.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final CountryService countryService;
    private final ImageService imageService;
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
        dto.setGrade(product.getAverageGrade());
        dto.setCoverImage(imageResponseDto(imageService
                .getAllImages(product.getImages())
                .getFirst()));
        return dto;
    }

    public ProductFullResponseDto toFullResponse(Product product) {
        var dto = new ProductFullResponseDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryName(product.getCategory().getName());
        dto.setBrandName(product.getBrand().getName());
        dto.setCountryName(product.getCountry().getName());
        dto.setGrade(product.getAverageGrade());
        dto.setImages(imageService.getAllImages(product.getImages()).stream()
                .map(this::imageResponseDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private List<String> storeImagesAndGetIds(List<MultipartFile> images) {
       return images.stream()
               .map(file -> {
                   var image = new Image();
                   image.setMimeType(file.getContentType());
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

    private ImageResponseDto imageResponseDto(Image image) {
        var dto = new ImageResponseDto();
        dto.setMimeType(image.getMimeType());
        dto.setImage(image.getImage());
        return dto;
    }
}
