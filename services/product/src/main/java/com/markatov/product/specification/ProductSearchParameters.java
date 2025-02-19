package com.markatov.product.specification;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductSearchParameters {
    private String name;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private List<String> brands;
    private List<String> countries;
}
