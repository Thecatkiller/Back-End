package com.opso.cheapshop;

import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.repository.UserRepository;

import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.exception.*;
import com.opso.cheapshop.service.UserServiceImpl;
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
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;

//@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
/*
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @TestConfiguration
    static class UserServiceImplTestConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }
    @Test
    @DisplayName("When getUserByTitle With Valid Title Then Returns Post")
    public void whenGetUserNameWithValidTitleThenReturnsPost() {
        // Arrange
        String title = "Ricardo Diaz";
        Long id = 1L;
        User user = new User().setId(id).setFirstname(title);
        when(userRepository.findById(id))
                .thenReturn(Optional.of(user));

        // Act
        User foundUser = userService.getUserById(id);

        // Assert
        assertThat(foundUser.getId()).isEqualTo(id);
    }

*/
}