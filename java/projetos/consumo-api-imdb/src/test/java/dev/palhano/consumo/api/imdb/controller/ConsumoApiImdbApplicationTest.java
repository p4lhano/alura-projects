package dev.palhano.consumo.api.imdb.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsumoApiImdbApplicationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate; 
	
	
	@Test @After
	void deveRetornarMelhores250Filmes() {
		ResponseEntity<String> response =
			this.restTemplate.getForEntity("http://localhost:" + port + "/250Filmes", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}
