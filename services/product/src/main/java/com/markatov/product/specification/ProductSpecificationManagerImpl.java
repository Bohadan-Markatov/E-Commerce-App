package com.markatov.product.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductSpecificationManagerImpl implements ProductSpecificationManager {
    private final List<ProductSpecificationProvider> providers;
    private Map<String, ProductSpecificationProvider> providerMap;

    @PostMapping
    private void initProvidersMap() {
        providerMap = new HashMap<>();
        providers.forEach(provider
                -> providerMap.put(provider.getColumnName(), provider));
    }

    @Override
    public ProductSpecificationProvider getProvider(String key) {
        return Optional.ofNullable(providerMap.get(key)).orElseThrow(()
                -> new RuntimeException("No provider found for key: " + key));
    }
}
