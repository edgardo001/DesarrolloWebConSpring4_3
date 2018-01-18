package com.edgardo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.edgardo.repository.CourseJpaRepository;

//Cuando spring parta, almacenara este componente en "memoria"
@Component("exampleComponent")
public class ExampleComponent {
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	public void sayhello() {
		courseJpaRepository.count();
		LOG.info("HELLO FROM EXAMPLECOMPONENT");
	}
	
	
}
