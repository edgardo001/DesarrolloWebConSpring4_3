package com.edgardo.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edgardo.model.Person;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";

	// Primera Forma para redireccionar
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}*/

	// Segunda Forma para redireccionar
	@GetMapping("/")
	public RedirectView redirect() {
		//Indicar el PATH a redireccionar
		return new RedirectView("/example3/showform");
	}

	// Muestra el formulario, entregando un objeto de tipo person
	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARN TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG");
		
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	// Rescata lo entregado por el formulario y lo muestra
	//@Valid para validar el dato entregado
	//BindingResult usado por spring para verificar los campos, 
	//cuando entre por el controlador tomara "bindingResult" 
	//y validara segun las anotaciones de Person, si no cumple,
	//bindingResult tendra todos los errores en su interior 
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		//En caso de error, retorna al form
		if (bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}		
		return mav;
	}
	
	// Muestra el formulario, entregando un objeto de tipo person
	@GetMapping("/showerror")
	public String showerror(Model model) {
		model.addAttribute("person", new Person());
		int i = 6/0;
		return FORM_VIEW;
	}
	
	

}
