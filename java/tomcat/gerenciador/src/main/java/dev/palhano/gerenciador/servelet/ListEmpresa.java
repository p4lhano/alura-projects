package dev.palhano.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.palhano.gerenciador.entitys.BD;
import dev.palhano.gerenciador.entitys.Empresa;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/listEmpresa")
public class ListEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("listando empresa empresa");
	   
	   BD bd = new BD();
	   
	   PrintWriter out = resp.getWriter(); // print Writer
	   out.write("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <title>Hellow Word</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "    <ul>\n");
		bd.getEmpresas().forEach(e -> out.write("    <li>"+e.getNome()+"</li>\n"));		
//				"    <li>"++"</li>\n";
				
		out.write("    </ul>\n"
			+ "</body>\n"
			+ "</html>");
	   
	   
	   
   }

}
