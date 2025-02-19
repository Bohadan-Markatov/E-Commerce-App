package com.markatov.product.dto.comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDto {
    private Long id;
    private Long productId;
    private String text;
    private byte grade;
    private LocalDateTime publicationDate;
    private String authorFirstName;
    private String authorLastName;
}
