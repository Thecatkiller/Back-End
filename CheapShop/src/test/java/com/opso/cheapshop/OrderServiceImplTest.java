package com.opso.cheapshop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.opso.cheapshop.domain.model.Order;
import com.opso.cheapshop.domain.model.Product;
import com.opso.cheapshop.domain.model.User;
import com.opso.cheapshop.domain.repository.OrderRepository;
import com.opso.cheapshop.domain.service.OrderService;
import com.opso.cheapshop.domain.service.ProductService;
import com.opso.cheapshop.domain.service.UserService;
import com.opso.cheapshop.exception.ValidationException;
import com.opso.cheapshop.service.OrderServiceImpl;

@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {
	@MockBean
	private  OrderRepository orderRepository;
	@Autowired
	private OrderService orderService;
	@MockBean
	private  UserService userService;
	@MockBean
	private  ProductService productService;

	private static String messageValidation="Not enough money to create the order";
	
	@TestConfiguration
	static class OrderServiceImplTestsConfiguration {
		@Bean
		public OrderService orderService() {
			return new OrderServiceImpl();
		}
	}

	@Test
	@DisplayName("When createOrder when user.money is not enought to create the Order")
	public void WhenCreateOrderWhenUserMoneyIsNotEnoughtToCreateTheOrder() {
		// arrange
		//User--
		Long user_id = 1L;
		double money = 0; //Se aprecia el dinero en 0
		String firstName = "Hans";
		String lastName = "Retes";
		//User--
		//Product--
		Long product_id = 2L;
		String name="Trident Z Memory";
		double price = 110;	//EL precio del Producto tecnolódigo es mayor con el que cuenta el usuario
		//Product--
		//Order---
		Long order_id=3L;
		String deliveryDate="10/05/2022";
		int quantity=1;
		//Order---
		User user = new User().setId(user_id).setMoney(money).setFirstname(firstName).setLastname(lastName);
		Product product = new Product().setId(product_id).setName(name).setPrice(price);
		Order order = new Order()
				.setId(order_id)
				.setDelivery_date(deliveryDate)
				.setQuantity(quantity)
				.setUserId(user.setId(user_id))
				.setProductId(product.setId(product_id));
		when(productService.getProductById(product_id)).thenReturn(product);
		when(userService.getUserById(user_id)).thenReturn(user);
		//act
		// assert
		try {
			Order foundOrder=(orderService.createOrder(order, user_id));
		}catch(Exception e) {
			assertThat(e instanceof ValidationException);
			assertEquals("Not enough money to create the order",e.getMessage());
			
		}	
		// done
	}
	
	
	
	
	
	
}
