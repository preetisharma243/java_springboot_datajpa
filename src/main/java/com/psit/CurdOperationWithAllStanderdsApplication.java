package com.psit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CurdOperationWithAllStanderdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOperationWithAllStanderdsApplication.class, args);
	}

}
