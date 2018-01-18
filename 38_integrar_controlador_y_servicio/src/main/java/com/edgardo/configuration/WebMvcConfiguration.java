package com.edgardo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.edgardo.component.RequestTimeInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	//Injectar
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Interceptor para calcular el tiempo de 1 transaccion
		registry.addInterceptor(requestTimeInterceptor);
	}

}
