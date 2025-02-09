package com.markatov.product.service.impl;

import com.markatov.product.model.Image;
import com.markatov.product.repository.ImageRepository;
import com.markatov.product.service.ImageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public String saveImage(Image image) {
        return imageRepository.save(image).getId();
    }

    @Override
    public Image getImage(String imageId) {
        return imageRepository.findById(imageId).orElseThrow(()
                -> new EntityNotFoundException("Could not find image with id: " + imageId));
    }
}
