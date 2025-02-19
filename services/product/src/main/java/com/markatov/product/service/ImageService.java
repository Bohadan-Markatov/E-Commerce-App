package com.markatov.product.service;

import com.markatov.product.model.Image;

import java.util.List;

public interface ImageService {

    String saveImage(Image image);

    Image getImage(String imageId);

    List<Image> getAllImages(List<String> imageIds);
}
