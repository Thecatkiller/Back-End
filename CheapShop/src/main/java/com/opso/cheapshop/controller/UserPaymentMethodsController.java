package com.opso.cheapshop.controller;

import com.opso.cheapshop.domain.model.UserPaymentMethod;
import com.opso.cheapshop.domain.service.UserPaymentMethodService;
import com.opso.cheapshop.resource.SaveUserPaymentMethodResource;
import com.opso.cheapshop.resource.UserPaymentMethodResource;
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
public class UserPaymentMethodsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserPaymentMethodService userPaymentMethodService;



    @Operation(summary = "Get UserPaymentMethod By ID", description = "Get UserPaymentMethod by ID", tags = {"userPaymentMethods"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserPaymentMethod returned", content = @Content(mediaType = "application/json"))

    })
    @GetMapping("/userPaymentMethod/{userPaymentMethodId}")
    public UserPaymentMethodResource getUserPaymentMethodById(
            @PathVariable Long userPaymentMethodId) {
        return convertToResource(userPaymentMethodService.getUserPaymentMethodById(userPaymentMethodId));
    }

    @Operation(summary = "Create a UserPaymentMethod", description = "Create a UserPaymentMethod", tags = {"userPaymentMethods"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserPaymentMethod created", content = @Content(mediaType = "application/json"))

    })
    @PostMapping("/userPaymentMethods/{userPaymentMethodId}")
    public UserPaymentMethodResource createUserPaymentMethod(@Valid @RequestBody SaveUserPaymentMethodResource resource) {
        UserPaymentMethod userPaymentMethod = convertToEntity(resource);
        return convertToResource(userPaymentMethodService.createUserPaymentMethod(userPaymentMethod));
    }

    @Operation(summary = "Update a UserPaymentMethod", description = "Update a UserPaymentMethod", tags = {"userPaymentMethods"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserPaymentMethod updated", content = @Content(mediaType = "application/json"))

    })
    @PutMapping("/userPaymentMethod/{userPaymentMethodId}")
    public UserPaymentMethodResource updateUserPaymentMethod(@PathVariable Long userPaymentMethodId, @Valid @RequestBody SaveUserPaymentMethodResource resource) {
        UserPaymentMethod userPaymentMethod = convertToEntity(resource);
        return convertToResource(userPaymentMethodService.updateUserPaymentMethod(userPaymentMethodId, userPaymentMethod));
    }

    @Operation(summary = "Delete a UserPaymentMethod", description = "Delete a UserPaymentMethod", tags = {"userPaymentMethods"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "UserPaymentMethod deleted", content = @Content(mediaType = "application/json"))

    })
    @DeleteMapping("/userPaymentMethod/{userPaymentMethodId}")
    public ResponseEntity<?> deleteUserPaymentMethod(@PathVariable Long userPaymentMethodId) {
        return userPaymentMethodService.deleteUserPaymentMethod(userPaymentMethodId);
    }

    private UserPaymentMethod convertToEntity(SaveUserPaymentMethodResource resource) {
        return mapper.map(resource, UserPaymentMethod.class);
    }

    private UserPaymentMethodResource convertToResource(UserPaymentMethod entity) {
        return mapper.map(entity, UserPaymentMethodResource.class);
    }
}