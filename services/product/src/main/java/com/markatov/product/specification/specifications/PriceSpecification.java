package com.markatov.product.specification.specifications;

import com.markatov.product.model.Product;
import com.markatov.product.specification.ProductSearchParameters;
import com.markatov.product.specification.ProductSpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PriceSpecification implements ProductSpecificationProvider {
    public static final String COLUMN_NAME = "price";

    @Override
    public Specification<Product> getSpecification(ProductSearchParameters parameters) {
        return ((root, query, criteriaBuilder)
                -> criteriaBuilder.between(root.get(COLUMN_NAME),
                parameters.getPriceFrom(),
                parameters.getPriceTo()));
    }

    @Override
    public String getColumnName() {
        return COLUMN_NAME;
    }
}
