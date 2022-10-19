package dev.palhano.server.comands;

import java.io.PrintStream;
import java.util.concurrent.Callable;

public class ComandoC2Part1 implements Callable<String> {

	private PrintStream cliente;

	public ComandoC2Part1(PrintStream saidaForCliente) {
		this.cliente = saidaForCliente;

	}

	@Override
	public String call() throws Exception {
		System.out.println("Runnabled c2");
		
		Thread.sleep(3000);
		
		cliente.println("Executado c2 p1. Finalizado.");
		
		return "OK";
	}

}
