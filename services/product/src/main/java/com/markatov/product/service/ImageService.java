package com.markatov.product.service;

import com.markatov.product.model.Image;

public interface ImageService {

    String saveImage(Image image);

    Image getImage(String imageId);
}
