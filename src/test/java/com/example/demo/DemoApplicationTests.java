package com.example.demo;

import com.example.demo.domain.Player;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:test.properties")
class DemoApplicationTests {
	TestRestTemplate testRestTemplate = new TestRestTemplate();

	@Test
	void contextLoads() {
	}

	@Test
	public void integrationTest(){
		ResponseEntity responseEntity = testRestTemplate.getForEntity("http://localhost:8080/api/players", Player.class);
		System.out.println(responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
	}
}
