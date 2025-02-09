package com.markatov.product.service.impl;

import com.markatov.product.repository.CommentRepository;
import com.markatov.product.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Double findAverageGradeByProductId(Long productId) {
        return commentRepository.findAverageGradeByProductId(productId).orElse(0.0);
    }
}
