package com.edgardo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edgardo.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";
	
	//Muestra el formulario, entregando un objeto de tipo person
	@GetMapping("/showform")
	public String showForm(Model model){
		model.addAttribute("person", new Person());		
		return FORM_VIEW;
	}
	
	//Rescata lo entregado por el formulario y lo muestra
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person){
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		return mav;
	}
	

}
