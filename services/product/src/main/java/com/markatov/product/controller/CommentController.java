package com.markatov.product.controller;

import com.markatov.product.dto.comment.CommentRequestDto;
import com.markatov.product.dto.comment.CommentResponseDto;
import com.markatov.product.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

//    public CommentResponseDto create(CommentRequestDto dto) {
//        return commentService.save(dto);
//    }
}
