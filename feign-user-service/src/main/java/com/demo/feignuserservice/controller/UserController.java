package com.demo.feignuserservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.feignuserservice.client.OrderClient;
import com.demo.feignuserservice.dto.OrderDto;

@RestController
public class UserController {
	
	@Autowired
	OrderClient	orderClient;
	
	@GetMapping("/users")
	public List<OrderDto> getAllUserOrder() {
		System.out.println("Feign user controller get all orders");
		return orderClient.getAllOrders();
	}
	
	@GetMapping("/users/{id}")
	public String getUserOrderGetForEntity(@PathVariable int id) {
		System.out.println("Feign user controller get order by path variable");
		return orderClient.getOrder(id);
	}
	
	@GetMapping("/byparam")
	public String getUserOrderByReqParam(@RequestParam int id) {
		System.out.println("Feign user controller get order by request param");
		return orderClient.getOrderByReqParam(id);
	}
	
	@GetMapping("/userspost")
	public OrderDto saveUserOrder() {
		OrderDto order = new OrderDto(9, "iphone", "apple");
		System.out.println("Feign user controller post request");
		return orderClient.saveOrder(order);
	}
	
}
