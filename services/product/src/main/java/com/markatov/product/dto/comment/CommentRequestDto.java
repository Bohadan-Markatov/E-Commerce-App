package com.markatov.product.dto.comment;

import lombok.Data;

@Data
public class CommentRequestDto {
    private Long productId;
    private String text;
    private byte grade;
}
