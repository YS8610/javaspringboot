package tfip.modserver.my1stspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class My1stspringbootApplication {

	final static private String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		
		String portToUse = DEFAULT_PORT;
		Logger logger = LoggerFactory.getLogger(My1stspringbootApplication.class);
		// logger.info("Hello World");
		SpringApplication app = new SpringApplication(My1stspringbootApplication.class);
		ApplicationArguments cmdarg = new DefaultApplicationArguments(args);
		
		if (cmdarg.containsOption("port")){
			portToUse = cmdarg.getOptionValues("port").get(0);
		}
		else if (System.getenv("PORT")!=null || !System.getenv("PORT").isEmpty() || !System.getenv("PORT").isBlank() ){
			portToUse = System.getenv("PORT");
		}
		else{
			portToUse = DEFAULT_PORT;
		}

		logger.info("port to use = " + portToUse);
		app.setDefaultProperties(Collections.singletonMap("server.port", portToUse));
		app.run(args);
	}
}
