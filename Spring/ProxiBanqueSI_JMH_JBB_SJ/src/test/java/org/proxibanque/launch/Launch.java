package org.proxibanque.launch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxibanque.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class })
public class Launch {

	private static Logger LOGGER = LoggerFactory.getLogger(Launch.class);
	@Test
	public void main() {

		LOGGER.warn(" ******** Test Logger ******** ");
		
	}
}
