package dev.palhano.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWordController {
	
	@GetMapping("/hello")//esse metodo por atender o controller é chamado de Action
	public String hello(Model request) {
		request.addAttribute("produtos", "Nome Vitor");
		
//		acima, tratamento em alto nivel
//		abaixo, tratamento em baixo nivel, diretamente no servelet
		
//	public String hello(HttpServletRequest request) {
//		request.setAttribute("produtos", "Nome Vitor");
		
		
		return "hello";//Ira retornar o arquicom HTML com nome, in /mudi/src/main/resources/templates/hello.html
	}
}
