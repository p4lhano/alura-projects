package dev.palhano.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	@GetMapping
	public String getFormForOfertas() {
		System.out.println("Chamou OfertaController.getFormForOfertas()");
		return "oferta/home";
	}
}
