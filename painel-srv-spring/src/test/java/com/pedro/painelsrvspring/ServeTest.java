package com.pedro.painelsrvspring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServeTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void test() {
		
		
		ResponseEntity<String> response = restTemplate.getForEntity("/test", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("ok", response.getBody());
	}

}
