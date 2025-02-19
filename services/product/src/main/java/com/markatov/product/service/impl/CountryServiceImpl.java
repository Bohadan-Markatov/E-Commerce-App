package com.markatov.product.service.impl;

import com.markatov.product.dto.country.CountryResponseDto;
import com.markatov.product.mapper.CountryMapper;
import com.markatov.product.model.Country;
import com.markatov.product.repository.CountryRepository;
import com.markatov.product.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    public Country findCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Country with id " + id + " not found"));
    }

    @Override
    public List<CountryResponseDto> getAll() {
        return countryRepository.findAll().stream()
                .map(countryMapper::toResponseDto)
                .toList();
    }
}
