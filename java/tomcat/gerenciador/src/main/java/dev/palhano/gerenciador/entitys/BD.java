package dev.palhano.gerenciador.entitys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BD {

	private static List<Empresa> lista = new ArrayList<>();
	
	
	/**
	 * Bloco estaico de codigo se será realizado unica vez quando a classe for chamada
	 * */
	static {
		Empresa s = new Empresa();
		s.setNome("Palhano");
		Empresa g = new Empresa();
		g.setNome("Google");
		BD.lista.add(g);
	}
	
	public void add(Empresa empresa) {
		lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return new ArrayList<Empresa>(Collections.unmodifiableList(lista))  ;
	}

}
