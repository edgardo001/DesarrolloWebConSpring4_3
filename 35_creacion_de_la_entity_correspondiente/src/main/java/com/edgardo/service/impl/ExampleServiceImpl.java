package com.edgardo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edgardo.model.Person;
import com.edgardo.service.ExampleService;

//Genera el bean al arrancar spring
//Para los "Service", siempre se debe implementar de una interfaz, luego solo se instancia la interfaz en el controller
//
//Ej:
//@Autowired
//@Qualifier("ExampleService")
//private ExampleService exampleService;
//
//Se declara solo la interfaz, no la clase
@Service("ExampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {		
		List<Person> people = new ArrayList<>();
		people.add(new Person("Edgaro", 28));
		people.add(new Person("Alberto", 30));
		people.add(new Person("Isabel", 26));
		people.add(new Person("Carolina", 27));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
