package com.markatov.product.specification;

import com.markatov.product.model.Product;
import com.markatov.product.specification.specifications.BrandSpecification;
import com.markatov.product.specification.specifications.CountrySpecification;
import com.markatov.product.specification.specifications.NameSpecification;
import com.markatov.product.specification.specifications.PriceSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSpecificationBuilderImpl implements ProductSpecificationBuilder {
    private final ProductSpecificationManager specificationManager;

    @Override
    public Specification<Product> build(ProductSearchParameters parameters) {
        Specification<Product> specification = Specification.where(null);

        if (parameters.getName() != null) {
            specification = specification.and(specificationManager
                    .getProvider(NameSpecification.COLUMN_NAME)
                    .getSpecification(parameters));
        }
        if (parameters.getCountries() != null && !parameters.getCountries().isEmpty()) {
            specification = specification.and(specificationManager
                    .getProvider(CountrySpecification.COLUMN_NAME)
                    .getSpecification(parameters));
        }
        if (parameters.getBrands() != null && !parameters.getBrands().isEmpty()) {
            specification = specification.and(specificationManager
                    .getProvider(BrandSpecification.COLUMN_NAME)
                    .getSpecification(parameters));
        }
        if (parameters.getPriceTo() != null || parameters.getPriceFrom() != null) {
            specification = specification.and(specificationManager
                    .getProvider(PriceSpecification.COLUMN_NAME)
                    .getSpecification(parameters));
        }
        return specification;
    }
}
