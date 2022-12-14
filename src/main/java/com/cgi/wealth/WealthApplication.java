package com.cgi.wealth;

import com.cgi.wealth.component.MobileComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WealthApplication {

	public static void main(String[] args) {
		log.info("After Java 7 main method is mandatory");
		SpringApplication.run(WealthApplication.class, args);
	}

}
