package dev.palhano;

import java.io.IOException;

import com.google.gson.Gson;

import dev.palhano.models.Top250FilmsResponse;
import dev.palhano.service.ImdbApiClient;
import dev.palhano.service.MovieService;
/**
 * @apiNote Download de Gson em https://repo1.maven.org/maven2/com/google/code/gson/gson/2.9.1/gson-2.9.1.jar
 * @author vitor
 * */
public class Initializer {
	private static String apiKey = "<CHAVE_API>";
	private static MovieService serviceMovie = new MovieService();
	

	public static void main(String[] args) throws IOException {
		
		String json = new ImdbApiClient().call(apiKey);

		Top250FilmsResponse tops = (new Gson()).fromJson(json, Top250FilmsResponse.class);
		
		serviceMovie.gerarHTML(tops);
		
		
	}
	 
}
