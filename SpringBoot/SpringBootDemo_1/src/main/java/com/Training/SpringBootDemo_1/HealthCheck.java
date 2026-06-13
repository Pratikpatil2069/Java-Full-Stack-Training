package com.Training.SpringBootDemo_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	@GetMapping("/")
	public String HealthCheck1() {
		return "Everything is ok";
	}

}
