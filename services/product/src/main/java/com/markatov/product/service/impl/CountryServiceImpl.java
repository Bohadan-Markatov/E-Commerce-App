package com.markatov.product.service.impl;

import com.markatov.product.model.Country;
import com.markatov.product.repository.CountryRepository;
import com.markatov.product.service.CountryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public Country findCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Country with id " + id + " not found"));
    }
}
