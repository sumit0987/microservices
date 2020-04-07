package com.demo.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.user.dto.OrderDto;


@RestController
public class UserController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/users")
	public String getAllUserOrder() {
		final String uri = "http://localhost:8080/orders";
		ResponseEntity<String> orders = restTemplate.getForEntity(uri, String.class);
		String orderList = orders.getBody();
		return "From usercontroller :"+orderList;
	}
	
	@GetMapping("/users/{id}")
	public String getUserOrderGetForEntity(@PathVariable int id) {
		final String uri = "http://localhost:8080/orders";
		ResponseEntity<String> order = restTemplate.getForEntity(uri+"/"+id, String.class);
		String userOrder = order.getBody();
		
		return "From usercontroller get for Entity :"+userOrder;
	}
	
//	@GetMapping("/users/{id}")
//	public String getUserOrderGetForObject(@PathVariable int id) {
//		final String uri = "http://localhost:8080/orders";
//		String userOrder = restTemplate.getForObject(uri+"/"+id,String.class);
//		
//		return "From usercontroller getForObject:"+userOrder;
//	}
	
	@GetMapping("/byparam")
	public String getUserOrderByReqParam(@RequestParam int id) {
		
		final String uri = "http://localhost:8080/orders/byparam";
		
		System.out.println("Inside user controller");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Integer> params = new HashMap<String,Integer>();
		params.put("id", id);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
		for(Map.Entry<String, Integer> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		
		String response = restTemplate.getForObject(builder.toUriString(), String.class);
		
		return response;
		
	}
	
	@GetMapping("/userspost")
	public String saveUserOrder() {
		final String uri = "http://localhost:8080/orders";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		OrderDto order = new OrderDto(9, "sports car", "Fiat");
		
		HttpEntity<OrderDto> entity=new HttpEntity<>(order,headers);
		
		return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
