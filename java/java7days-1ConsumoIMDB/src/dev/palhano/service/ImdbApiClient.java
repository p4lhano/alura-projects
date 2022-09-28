package dev.palhano.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImdbApiClient {

	private static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		String resposta, jsonEmString = "";
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}
	/**
	 * Faz a chamada para a API e retorna o json em string
	 * 
	 * @return String - JSON somente com lista de filmes
	 * @param apiKeyClient chave gerada no site do IMDB
	 * */
	public String call(String apiKeyClient) throws IOException {
		URL url = new URL(String.join("https://imdb-api.com/en/API/Top250Movies/",apiKeyClient));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if (conn.getResponseCode() != 200)
			System.out.println("Deu erro");
			
		InputStreamReader is = new InputStreamReader(conn.getInputStream());
		BufferedReader brResposta =  new BufferedReader(is);
		
		return converteJsonEmString(brResposta);
		
	}
}
