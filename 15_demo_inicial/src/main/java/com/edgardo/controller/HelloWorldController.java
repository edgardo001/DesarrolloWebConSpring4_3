package com.edgardo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//Bean de Spring
//Nombre del primer PATH a nivel de clase
@Controller
@RequestMapping("/say")
public class HelloWorldController {

	//Anotacion de spring 4.3
	@GetMapping("/helloworld")
	public String helloWorld(){
		//Retorna la vista con de nombre helloworld
		return "helloworld";
	}
}
