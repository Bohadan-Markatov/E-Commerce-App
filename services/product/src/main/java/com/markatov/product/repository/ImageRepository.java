package com.markatov.product.repository;

import com.markatov.product.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}
