package dev.palhano.mudi.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.palhano.mudi.interceptor.Acess;
import dev.palhano.mudi.interceptor.AcessInteceptor;

@RestController
@RequestMapping("api/home")
public class HomeRestController {
	@GetMapping
	public List<Acess> getAcess() {
		return AcessInteceptor.getAcesss();
	}
}
