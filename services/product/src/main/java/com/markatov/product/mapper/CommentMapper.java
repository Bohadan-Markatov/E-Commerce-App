package com.markatov.product.mapper;

import com.markatov.product.dto.comment.CommentRequestDto;
import com.markatov.product.dto.comment.CommentResponseDto;
import com.markatov.product.model.Comment;
import com.markatov.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentMapper {
    private final ProductService productService;

    public Comment toModel(CommentRequestDto dto) {
        var comment = new Comment();
        comment.setProduct(productService.getProduct(dto.getProductId()));
        comment.setText(dto.getText());
        comment.setPublicationDate(LocalDateTime.now());
        comment.setGrade(dto.getGrade());
        // TODO: "Implement process of getting user information from user service"
//        comment.setAuthorId(dto.getAuthorId());
//        comment.setAuthorEmail(dto.getAuthorEmail());
//        comment.setAuthorFirstName(dto.getAuthorFirstName());
//        comment.setAuthorLastName(dto.getAuthorLastName());
        return comment;
    }

    public CommentResponseDto toDto(Comment comment) {
        var responseDto = new CommentResponseDto();
        responseDto.setId(comment.getId());
        responseDto.setProductId(comment.getProduct().getId());
        responseDto.setText(comment.getText());
        responseDto.setPublicationDate(comment.getPublicationDate());
        responseDto.setGrade(comment.getGrade());
        responseDto.setAuthorFirstName(comment.getAuthorFirstName());
        responseDto.setAuthorLastName(comment.getAuthorLastName());
        return responseDto;
    }
}
