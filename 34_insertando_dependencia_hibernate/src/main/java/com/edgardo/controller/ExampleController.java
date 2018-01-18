package com.edgardo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edgardo.component.ExampleComponent;
import com.edgardo.model.Person;
import com.edgardo.service.ExampleService;


//Bean de Spring, Controller hereda de Component
@Controller
//Nombre del primer PATH a nivel de clase
@RequestMapping("/example")
public class ExampleController {
	
	//Como buena practica se recomienda declarar las vistas en una clase especifica
	public static final String EXAMPLE_VIEW= "example";
	
	//Injectar un componente que se encuentra en memoria
	@Autowired
	//Indica a spring el nombre del bean que esta en memoria
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	@Autowired
	@Qualifier("ExampleService")
	//Se declara solo la interfaz, no la clase
	private ExampleService exampleService;
	
	//Primera forma
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	//Anotacion hija de RequestMapping, para ahorrar escritura
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		exampleComponent.sayhello();
		//Nombre en la plantilla y su objeto asociado.
		//El controller solo puede llamar servicios
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;//no es necesario añadir el .html
	}
	
	//Segunda forma
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	//Anotacion hija de RequestMapping, para ahorrar escritura
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);//Pasar nombre de la plantilla
		//Nombre en la plantilla y su objeto asociado.
		//El controller solo puede llamar servicios
		mav.addObject("people", exampleService.getListPeople());
		return mav;//no es necesario añadir el .html
	}	
}
