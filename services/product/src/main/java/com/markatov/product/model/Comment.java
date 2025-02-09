package com.markatov.product.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private LocalDateTime publicationDate;
    private byte grade;
    @Column(nullable = false)
    private Long authorId;
    @Column(nullable = false)
    private String authorEmail;
    @Column(nullable = false)
    private String authorFirstName;
    @Column(nullable = false)
    private String authorLastName;
}
