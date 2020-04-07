package com.demo.order.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.dto.OrderDto;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("")
	public List<OrderDto> getAllOrders() {
		List<OrderDto> orders = new ArrayList<OrderDto>();
		orders.add(new OrderDto(1,"television","samsung"));
		orders.add(new OrderDto(2,"television","sony"));
		return orders;
	}
	
	@GetMapping("/{id}")
	public String getOrder(@PathVariable int id) {
		List<OrderDto> orders = new ArrayList<OrderDto>();
		orders.add(new OrderDto(1,"television","samsung"));
		orders.add(new OrderDto(2,"television","sony"));
		
		return orders.get(id).toString();
	}
	
	@PostMapping("")
	public OrderDto saveOrder(@RequestBody OrderDto order) {
		OrderDto orderdto = new OrderDto();
		orderdto.setId(order.getId());
		orderdto.setName(order.getName());
		orderdto.setBrand(order.getBrand());
		System.out.println("product created");
		return orderdto;
	}
	
	@GetMapping("/byparam")
	public String getOrderByReqParam(@RequestParam int id) {
		System.out.println("Inside order controller");
		List<OrderDto> orders = new ArrayList<OrderDto>();
		orders.add(new OrderDto(1,"television","samsung"));
		orders.add(new OrderDto(2,"television","sony"));
		
		return orders.get(id).toString();
	}
}
