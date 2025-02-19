package com.markatov.product.dto.image;

import lombok.Data;

@Data
public class ImageResponseDto {
    private String mimeType;
    private byte[] image;
}
