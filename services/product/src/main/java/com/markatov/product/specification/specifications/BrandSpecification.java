package com.markatov.product.specification.specifications;

import com.markatov.product.model.Product;
import com.markatov.product.specification.ProductSearchParameters;
import com.markatov.product.specification.ProductSpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BrandSpecification implements ProductSpecificationProvider {
    public static final String COLUMN_NAME = "brand";

    @Override
    public Specification<Product> getSpecification(ProductSearchParameters parameters) {
        return ((root, query, criteriaBuilder)
                -> root.get(COLUMN_NAME).in(Arrays.stream(parameters.getBrands().toArray())));
    }

    @Override
    public String getColumnName() {
        return COLUMN_NAME;
    }
}
