package dev.palhano.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import dev.palhano.models.Top250FilmsItem;

public class HTMLGenerator  {
	private Writer html;
	private String head =
			"<head>\n"
			+ "		<meta charset=\"utf-8\">\n"
			+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
			+ "		<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" \n"
			+ "		+ \"integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					\n"
			+ "</head>";

	HTMLGenerator(Writer writer) throws IOException {
		this.html = writer;
		this.html.write("<!DOCTYPE html><html lang=\"en\">");
		this.html.write(head);
	}
	
	public void closeHtml() throws IOException {
		this.html.write("</html>");
		html.close();
	}
	
	
	public void generate(List<Top250FilmsItem> listMovies) throws IOException {
		this.html.write("<body style=\"display: flex; flex-wrap: wrap; padding: 5px;\">");
		listMovies.forEach((Top250FilmsItem movie) -> {
			try {
//				System.out.println("Gerando DIV de: "+ movie.getFullTitle());
				html.write("<div class=\"card bg-dark text-white mb-1 h-25 rounded\" style=\"max-width: 15rem; margin: 10px;\">");
				html.write("\t<img class=\"card-img-top\" src=\""+ movie.getImage() +"\" alt=\"Card image cap\">\n"
						+ "\t<div class=\"card-body\">\n"
						+ "\t\t<h5 class=\"card-title\">"+movie.getTitle()+"</h5>\n"
						+ "\t\t<p class=\"card-subtitle mb-2 text-muted\">Nota: "+ movie.getNota() + " Ano: " + movie.getYear()+ "</p>\n"
						+ "\t</div>\n");
				this.html.write("</div>\n");
				this.html.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		this.html.write("</body>");
	}
}
