package net.mihussain.ems;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EmsBackendApplication {
	public static Logger  logger = LogManager.getLogger();
	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);
		logger.info("Employee Management System Application started");
	}

}
