package dev.palhano.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import dev.palhano.models.Top250FilmsResponse;

public class MovieService {
	public void gerarHTML(Top250FilmsResponse responseMovies) throws IOException {
		PrintWriter prWriter = new PrintWriter(new File("index.html"));
		HTMLGenerator html = new HTMLGenerator(prWriter);
		html.generate(responseMovies.items);
		html.closeHtml();
	}
	
	
	
}
