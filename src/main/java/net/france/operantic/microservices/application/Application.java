package net.france.operantic.microservices.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author atalati
 */
@SpringBootApplication
public class Application {
	private static final Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		logger.debug("Hello from Log4j 2 - num : {}", Application.class);
		SpringApplication.run(Application.class, args);
	}

}
