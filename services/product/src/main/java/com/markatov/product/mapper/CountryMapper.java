package com.markatov.product.mapper;

import com.markatov.product.dto.country.CountryResponseDto;
import com.markatov.product.model.Country;
import org.springframework.stereotype.Service;

@Service
public class CountryMapper {

    public CountryResponseDto toResponseDto(Country country) {
        var countryResponseDto = new CountryResponseDto();
        countryResponseDto.setId(country.getId());
        countryResponseDto.setName(country.getName());
        return countryResponseDto;
    }
}
