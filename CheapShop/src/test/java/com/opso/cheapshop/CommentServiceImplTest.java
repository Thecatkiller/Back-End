package com.opso.cheapshop;

import com.opso.cheapshop.domain.model.Comment;
import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.repository.CommentRepository;
import com.opso.cheapshop.domain.repository.UserRepository;
import com.opso.cheapshop.domain.service.CommentService;
import com.opso.cheapshop.service.CommentServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CommentServiceImplTest {

    @MockBean
    private CommentRepository commentRepository;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private CommentService commentService;

    @TestConfiguration
    static class CommentServiceConfiguration{
        @Bean
        public CommentService commentService(){
            return new CommentServiceImpl();
        }
    }

    @Test
    @DisplayName("When getCommentById With Valid ID Then Returns Post")
    public void WhenGetCommentByIdWithValidIdThenReturnsUser(){
        //ARRANGE
        Long id = 1L;
        Comment comment=new Comment().setId(id);
        when(commentRepository.findById(id)).thenReturn(Optional.of(comment));
        //ACT
        Comment foundComment=commentService.getCommentById(id);
        //ASSERT
        assertThat(foundComment.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("When getCommentById With Valid ID When I Want Change The Description Then Returns Post")
    public void WhenGetCommentByIdWithValidIdWhenIWantChangeTheDescriptionThenReturnsPost() {
        // Arrange
        String new_description = "Que buen producto!";
        String description = "Que bune producto!";
        Long id = 1L;
        Comment comment = new Comment().setId(id).setDescription(description);
        when(commentRepository.findById(id))
                .thenReturn(Optional.of(comment));

        // Act
        comment.setDescription(new_description);
        commentService.updateComment(id,comment);
        Comment foundComment = commentService.getCommentById(id);
        // Assert
        assertThat(foundComment.getDescription()).isEqualTo(new_description);
    }

    @Test
    @DisplayName("When getcomment With Value User Id Then Returns Firstname")
    public void WhenGetCommentWithValueUserIdThenReturnsFirstname(){
        //ARRANGE
        Long comment_id=1L;
        Long user_id=1L;
        User user=new User().setId(user_id);
        Comment comment=new Comment().setId(comment_id).setUser(user);
        when(commentRepository.findById(comment_id))
                .thenReturn(Optional.of(comment));
        //ACT
        Comment foundComment = commentService.getCommentById(comment_id);
        User user1 = foundComment.getUser();
        //ASSERT
        assertThat(user1.getId()).isEqualTo(user_id);
    }
}
