package com.opso.cheapshop.controller;

import com.opso.cheapshop.domain.model.Order;
import com.opso.cheapshop.domain.service.OrderService;
import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.resource.OrderResource;
import com.opso.cheapshop.resource.SaveOrderResource;
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
@RequestMapping({"/api"})
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    public OrdersController() {
    }
    @Operation(summary = "Get all Orders", description = "Get All Orders ", tags = {"orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Orders returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping({"/orders"})
    public Page<OrderResource> getAllOrders(Pageable pageable) {
        List<OrderResource> orders = (List)this.orderService.getAllOrders(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int orderCount = orders.size();
        return new PageImpl(orders, pageable, (long)orderCount);
    }

    @Operation(summary = "Get Order by Id", description = "Get Order by Id", tags = {"orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order returned", content = @Content(mediaType = "application/json"))
    })
    @GetMapping({"/orders/{id}"})
    public OrderResource getOrderById(@PathVariable(name = "id") Long orderId) {
        return this.convertToResource(this.orderService.getOrderById(orderId));
    }

    @Operation(summary = "Create new Order", description = "Create new Order", tags = {"orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create new Order", content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/users/{userId}/orders")
    public OrderResource createOrder(@PathVariable Long userId, @Valid @RequestBody SaveOrderResource resource) {
        Order order = convertToEntity(resource);
        order.setUser(userService.getUserById(userId));
        return convertToResource(orderService.createOrder(order));
    }

    @Operation(summary = "Update Order", description = "Update Order by Id", tags = {"orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update Order by Id", content = @Content(mediaType = "application/json"))
    })
    @PutMapping({"/orders/{id}"})
    public OrderResource updateOrder(@PathVariable(name = "id") Long orderId, @Valid @RequestBody SaveOrderResource resource) {
        return this.convertToResource(this.orderService.updateOrder(orderId, this.convertToEntity(resource)));
    }
    @Operation(summary = "Delete Order", description = "Delete Order by Id", tags = {"orders"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete Order by Id", content = @Content(mediaType = "application/json"))
    })
    @DeleteMapping({"/orders/{ordersId}"})
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        return this.orderService.deleteOrder(orderId);
    }

    private Order convertToEntity(SaveOrderResource resource) {
        return (Order)this.mapper.map(resource, Order.class);
    }

    private OrderResource convertToResource(Order entity) {
        return (OrderResource)this.mapper.map(entity, OrderResource.class);
    }
}