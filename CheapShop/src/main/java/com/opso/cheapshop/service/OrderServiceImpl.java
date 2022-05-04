package com.opso.cheapshop.service;

import com.opso.cheapshop.domain.model.Order;
import com.opso.cheapshop.domain.model.Product;
import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.repository.OrderRepository;
import com.opso.cheapshop.domain.service.OrderService;
import com.opso.cheapshop.domain.service.ProductService;
import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.exception.ResourceNotFoundException;
import com.opso.cheapshop.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final UserService userService;
	private final ProductService productService;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductService productService) {
		this.orderRepository = orderRepository;
		this.userService = userService;
		this.productService = productService;
	}


	public Page<Order> getAllOrders(Pageable pageable) {
		return this.orderRepository.findAll(pageable);
	}
	//

	public Page<Order> getAllOrdersByUserId(Long userId, Pageable pageable) {
		return orderRepository.findByUserId(userId, pageable);
	}

	//
	public Order getOrderById(Long orderId) {
		return (Order) this.orderRepository.findById(orderId).orElseThrow(() -> {
			return new ResourceNotFoundException("Order", "Id", orderId);
		});
	}

	public Order createOrder(Order order, Long userId) {

		log.info("Create order with product {} for user : {}",  order.getProduct().getId(), userId);

		Product product = productService.getProductById(order.getProduct().getId());
		User user = userService.getUserById(userId);

		double totalPrice = product.getPrice() * order.getQuantity();

		if(totalPrice > user.getMoney()){
			throw new ValidationException("Not enough money to create the order");
		}

		log.info("User current money : {}", user.getMoney());
		user.setMoney(user.getMoney() - totalPrice);

		log.info("User new money : {}", user.getMoney());

		order.setUser(user);
		order.setPurchase_date(Timestamp.from(Instant.now()));

		return this.orderRepository.save(order);
	}

	public Order updateOrder(Long orderId, Order orderDetails) {

		return (Order) this.orderRepository.findById(orderId).map((order) -> {
			order.setDelivery_address(orderDetails.getDelivery_address());
			order.setDelivery_date(orderDetails.getDelivery_date());
			return (Order) this.orderRepository.save(order);
		}).orElseThrow(() -> {
			return new ResourceNotFoundException("Order", "Id", orderId);
		});
	}

	public ResponseEntity<?> deleteOrder(Long orderId) {
		return (ResponseEntity<?>) this.orderRepository.findById(orderId).map((order) -> {
			this.orderRepository.delete(order);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> {
			return new ResourceNotFoundException("Order", "Id", orderId);
		});
	}
}