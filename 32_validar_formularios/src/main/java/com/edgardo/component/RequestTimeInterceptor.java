package com.edgardo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
// Por cada peticion que se realize al server, pasara por esta clase
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	//===================================================
	//Para que esto funcione, se debe dar de alta en webmvc.config, se debe crear una clase java de configuracion (WebMvcConfiguration.java)
	//===================================================
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	// PRIMERO
	// Se ejecuta antes de entrar en el metodo del controlador
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// Se configura un atributo a la request para guardarlo al volve
		// Antes de que se ejecute el controlador, se almacena en la peticion el
		// tiempo actual en milisegundos
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	// SEGUNDO
	// Se ejecuta antes de "escupir" la vista en el navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--REQUEST URL: '" + request.getRequestURL().toString() + "' --TOTAL TIME: '"
				+ (System.currentTimeMillis() - startTime) + "' ms");

	}

}
