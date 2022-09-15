package dev.palhano.gerenciador.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/NovaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   System.out.println("Cadastrando empresa");
	   String nomeEmpresa = req.getParameter("nome") ;
	   Empresa empresa = new Empresa();
	   empresa.setNome(nomeEmpresa);
	   
	   BD bd = new BD();
	   bd.add(empresa);
	   
	   // Dispachador, nesse caso vai dispachar para o JSP
	   RequestDispatcher dispatcher = req.getRequestDispatcher("/cadastroEmpresa.jsp");
	   
	   req.setAttribute("nomeEmpresa", nomeEmpresa);
	   
	   // Finalize e envie para o dispacher cadastrado
	   dispatcher.forward(req, resp);
	   
	   
   }

}
