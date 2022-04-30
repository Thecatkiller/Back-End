package com.opso.cheapshop.service;

import com.opso.cheapshop.domain.model.Comment;
import com.opso.cheapshop.domain.repository.CommentRepository;
import com.opso.cheapshop.domain.repository.UserRepository;
import com.opso.cheapshop.domain.service.CommentService;
import com.opso.cheapshop.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Comment> getAllComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
    }

    @Override
    public Comment getCommentByIdAndUserId(Long userId, Long commentId) {
        return commentRepository.findByIdAndUserId(commentId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Comment not found with Id" + commentId +
                                " and PostId " + userId));
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long commentId, Comment commentRequest) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        return commentRepository.save(
                comment.setDescription(commentRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Id", commentId));
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }
}