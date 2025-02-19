package com.markatov.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany
    private List<Comment> comments;
    @ElementCollection
    private List<String> images;

    @Transient
    public Double getAverageGrade() {
        if (comments == null || comments.isEmpty()) {
            return 0.0;
        }
        var averageGrade = comments.stream()
                .mapToDouble(Comment::getGrade)
                .average()
                .orElse(0.0);
        return Math.round(averageGrade * 10.0) / 10.0;
    }
}
