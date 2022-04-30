package com.opso.cheapshop.controller;

import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.resource.SaveUserResource;
import com.opso.cheapshop.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @Operation(summary = "Get Users", description = "Get All Users by Page", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Users returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/users")
    public Page<UserResource> getAllUser(Pageable pageable) {
        Page<User> userPage = userService.getAllUsers(pageable);
        List<UserResource> resources = userPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get User By ID", description = "Get User by ID", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/users/{userId}")
    public UserResource getUserById(
            @PathVariable Long userId) {
        return convertToResource(userService.getUserById(userId));
    }

    @Operation(summary = "Create a User", description = "Create a User", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/users/{userId}")
    public UserResource createUser(@Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.createUser(user));
    }

    @Operation(summary = "Update a User", description = "Update a User", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/users/{userId}")
    public UserResource updateUser(@PathVariable Long userId, @Valid @RequestBody SaveUserResource resource) {
        User user = convertToEntity(resource);
        return convertToResource(userService.updateUser(userId, user));
    }

    @Operation(summary = "Delete a User", description = "Delete a User", tags = {"users"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    private User convertToEntity(SaveUserResource resource) {
        return mapper.map(resource, User.class);
    }

    private UserResource convertToResource(User entity) {
        return mapper.map(entity, UserResource.class);
    }
}