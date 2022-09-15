package dev.palhano.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi") // Utilizado para definir a URL que será utilizada para acessar a classe
public class HellowWord extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException/* throws ServletException, IOException*/ {
		// TODO Auto-generated method stub
		// super.service(req, resp);
		
		
		PrintWriter writer = resp.getWriter();
		writer.println("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Hellow Word</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <h1>Servelet</h1>\n"
				+ "</body>\n"
				+ "</html>");
		
	}
	
}
