package com.edgardo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

//Cuando spring parta, almacenara este componente en "memoria"
@Component("exampleComponent")
public class ExampleComponent {
	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

	public void sayhello() {
		LOG.info("HELLO FROM EXAMPLECOMPONENT");
	}
	
	
}
