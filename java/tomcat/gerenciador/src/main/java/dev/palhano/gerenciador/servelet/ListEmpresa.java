package dev.palhano.gerenciador.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.palhano.gerenciador.entitys.BD;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/listEmpresa")
public class ListEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("listando empresas");
	   
	   BD bd = new BD();
	   	
	   req.setAttribute("empresas", bd.getEmpresas());
	   
	   req.getRequestDispatcher("/listEmpresa.jsp").forward(req, resp);
	   
   }

}
