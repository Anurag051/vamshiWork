package com.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anurag.service.HelloService;
@Controller
public class HelloController{
	@Autowired
	private HelloService helloService;
	@RequestMapping(value="hello",method=RequestMethod.POST)
	public ModelAndView sayHello(@RequestParam("name") String name){
		String message=null;
		String targetView="/WEB-INF/pages/showMessage.jsp";
		if (name!=null && name.trim().length()>0) {
			message=helloService.sayHello(name);
		}else {
			message=helloService.sayHello("Guest");
		}
		ModelAndView modelAndView=new ModelAndView(targetView, "message", message);
		return modelAndView;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
}
