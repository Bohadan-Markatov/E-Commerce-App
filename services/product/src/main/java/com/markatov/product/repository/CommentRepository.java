package com.markatov.product.repository;

import com.markatov.product.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Double> findAverageGradeByProductId(Long productId);
}
