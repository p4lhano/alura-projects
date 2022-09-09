package dev.palhano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.Gson;

import dev.palhano.models.Top250FilmsResponse;
/**
 * @apiNote Download de Gson em https://repo1.maven.org/maven2/com/google/code/gson/gson/2.9.1/gson-2.9.1.jar
 * @author vitor
 * */
public class Initializer {
	private static String urlChamada = "https://imdb-api.com/en/API/Top250Movies/<API_KEY>";

	
	
	public static void main(String[] args) throws IOException {
		
		URL url = new URL(urlChamada);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if (conn.getResponseCode() != 200)
			System.out.println("Deu erro");
		
		InputStreamReader is = new InputStreamReader(conn.getInputStream());
		BufferedReader brResposta =  new BufferedReader(is);
		
		String json = converteJsonEmString(brResposta);
		
		Top250FilmsResponse tops = (new Gson()).fromJson(json, Top250FilmsResponse.class);
		
		tops.items.forEach(System.out::println);
		
//		System.out.println(BrResposta.readLine());
		
	}

	
	 private static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
	        String resposta, jsonEmString = "";
	        while ((resposta = buffereReader.readLine()) != null) {
	            jsonEmString += resposta;
	        }
	        return jsonEmString;
	    }
	 
}
