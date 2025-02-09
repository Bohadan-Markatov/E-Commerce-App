package com.markatov.product.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Long availableQuantity;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images;
}
