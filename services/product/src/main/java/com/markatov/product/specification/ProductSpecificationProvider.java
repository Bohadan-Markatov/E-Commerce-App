package com.markatov.product.specification;

import com.markatov.product.model.Product;
import org.springframework.data.jpa.domain.Specification;

public interface ProductSpecificationProvider {

    Specification<Product> getSpecification(ProductSearchParameters parameters);

    String getColumnName();
}
