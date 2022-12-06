package com.ute.application.service;

import com.ute.application.entity.Comment;
import com.ute.application.model.request.CreateCommentPostRequest;
import com.ute.application.model.request.CreateCommentProductRequest;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment createCommentPost(CreateCommentPostRequest createCommentPostRequest, long userId);
    Comment createCommentProduct(CreateCommentProductRequest createCommentProductRequest, long userId);
}
