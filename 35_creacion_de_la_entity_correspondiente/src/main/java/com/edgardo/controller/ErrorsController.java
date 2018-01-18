package com.edgardo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Esta clase se encarga de controlar los errores
@ControllerAdvice
public class ErrorsController {
	//ISE=Internal Server Error
	public static final String ISE_VIEW ="error/500";
	
	//Esta notacion indica a spring que en caso de error, pase por este metodo
	@ExceptionHandler(Exception.class)
	public String showInternalServerError(){
		return ISE_VIEW;
	}
}
