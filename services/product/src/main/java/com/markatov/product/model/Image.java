package com.markatov.product.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Image {
    @Id
    private String id;
    private byte[] image;
}
