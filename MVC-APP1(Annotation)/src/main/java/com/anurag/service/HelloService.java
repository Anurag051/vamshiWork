package com.anurag.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String sayHello(String name) {
		String message="Hello : "+name+" Welcome to SpringMVC ";
		return message;
	}

}
