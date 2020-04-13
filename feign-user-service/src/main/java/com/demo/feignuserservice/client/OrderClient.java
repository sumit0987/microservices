package com.demo.feignuserservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.feignuserservice.dto.OrderDto;

//@FeignClient(value="order-service",url="http://127.0.0.1:8080/orders")
@FeignClient(name="http://order-service/orders")
public interface OrderClient {
	
	@GetMapping("/info")
	public String getPortNo();
	
	@GetMapping("")
	public List<OrderDto> getAllOrders();
	
	@GetMapping("/{id}")
	public String getOrder(@PathVariable("id") int id);
	
	@GetMapping("/byparam")
	public String getOrderByReqParam(@RequestParam("id") int id);
	
	@PostMapping("")
	public OrderDto saveOrder(@RequestBody OrderDto order);
}
