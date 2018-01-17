package com.edgardo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final String EXAMPLE2_VIEW = "example2";
	
	//localhost:puerto/example2/request1?nm=EDGARDO
	//localhost:puerto/example2/request1?nm=ALBERTO
	//El parametro "nm" por defecto es obligatorio (si no se entrega, da error), al indicar "required=false", puede no pasarse
	//El parametro "defaultValue="NULL"", indica un parametro por defecto, en caso de que no venga la variable
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required=false,  defaultValue="NULL") String name){
		ModelAndView mav= new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model",name);
		return mav;
	}
	
	//Peticion GET con paso de parametros por el PATH de la request
	//localhost:puerto/example2/request2/EDGARDO
	//localhost:puerto/example2/request2/ALBERTO
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable(name = "nm") String name){
		ModelAndView mav= new ModelAndView(EXAMPLE2_VIEW);
		mav.addObject("nm_in_model",name);
		return mav;
	}
}
