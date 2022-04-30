package com.opso.cheapshop.controller;
import com.opso.cheapshop.domain.model.Order;
import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.service.OrderService;
import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.resource.OrderResource;
import com.opso.cheapshop.resource.SaveOrderResource;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class OrdersByUserController {

    @Autowired
    private OrderService orderService;


    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get all OrdersByUserId", description = "Get All Orders by UserID ", tags = {"ordersByUserId"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Orders by User Id returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/users/{userId}/orders")
    public List<OrderResource> getAllOrdersByUserId(
            @PathVariable(name = "userId") Long userId, Pageable pageable){

        Page<Order> orderPage = orderService.getAllOrdersByUserId(userId,pageable);
        List<OrderResource> resources = orderPage.getContent().stream().map(
                this::convertToResource).collect(Collectors.toList());
        // return new PageImpl<>(resources,pageable,resources.size());
        return resources;
    }


    private OrderResource convertToResource(Order entity){
        return mapper.map(entity,OrderResource.class);
    }
}
