package com.markatov.product.controller;

import com.markatov.product.dto.country.CountryResponseDto;
import com.markatov.product.model.Country;
import com.markatov.product.service.CountryService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@NotNull @NotEmpty String name) {
        var country = new Country();
        country.setName(name);
        countryService.save(country);
    }

    @GetMapping("/all")
    public List<CountryResponseDto> getAll() {
        return countryService.getAll();
    }
}
