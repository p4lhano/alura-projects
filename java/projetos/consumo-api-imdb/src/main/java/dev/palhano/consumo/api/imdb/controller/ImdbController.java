package dev.palhano.consumo.api.imdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImdbController {

	@Value("${imdb.url}")
	private String urlApi;
	@Value("${imdb.apiKey}")
	private String keyApi;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/top250")
	public void getfims(){
		String urlChamada = urlApi + keyApi;
		ResponseEntity<String> filmes = restTemplate.getForEntity(urlChamada, String.class);
		filmes.getBody();
		System.out.println(filmes.getBody());
	}
}
