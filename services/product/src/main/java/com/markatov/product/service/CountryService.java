package com.markatov.product.service;

import com.markatov.product.dto.country.CountryResponseDto;
import com.markatov.product.model.Country;

import java.util.List;

public interface CountryService {

    void save(Country country);

    Country findCountryById(Long id);

    List<CountryResponseDto> getAll();
}
