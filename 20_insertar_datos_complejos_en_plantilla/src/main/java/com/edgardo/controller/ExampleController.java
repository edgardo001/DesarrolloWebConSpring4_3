package com.edgardo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edgardo.model.Person;


//Bean de Spring, Controller hereda de Component
@Controller
//Nombre del primer PATH a nivel de clase
@RequestMapping("/example")
public class ExampleController {
	
	//Como buena practica se recomienda declarar las vistas en una clase especifica
	public static final String EXAMPLE_VIEW= "example";
	
	//Primera forma
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	//Anotacion hija de RequestMapping, para ahorrar escritura
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		//Nombre en la plantilla y su objeto asociado.
		model.addAttribute("person", new Person("Edgardo", 28));
		return EXAMPLE_VIEW;//no es necesario añadir el .html
	}
	
	//Segunda forma
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	//Anotacion hija de RequestMapping, para ahorrar escritura
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);//Pasar nombre de la plantilla
		//Nombre en la plantilla y su objeto asociado.
		mav.addObject("person", new Person("Alberto", 30));
		return mav;//no es necesario añadir el .html
	}
}
