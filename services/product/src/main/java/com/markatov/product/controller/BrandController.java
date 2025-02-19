package com.markatov.product.controller;

import com.markatov.product.dto.brand.BrandResponseDto;
import com.markatov.product.model.Brand;
import com.markatov.product.service.BrandService;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NonNull @NotEmpty String name) {
        var brand = new Brand();
        brand.setName(name);
        brandService.save(brand);
    }

    @GetMapping("/all")
    public List<BrandResponseDto> getAll() {
        return brandService.findAllBrands();
    }
}
