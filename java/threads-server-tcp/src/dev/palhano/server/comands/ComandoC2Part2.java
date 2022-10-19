package dev.palhano.server.comands;

import java.io.PrintStream;
import java.util.concurrent.Callable;

public class ComandoC2Part2 implements Callable<String> {

	private PrintStream cliente;

	public ComandoC2Part2(PrintStream saidaForCliente) {
		this.cliente = saidaForCliente;

	}

	@Override
	public String call() throws Exception {
		System.out.println("Runnabled c2 Parte 2");
		
		Thread.sleep(10000);
		
		cliente.println("Executado c2 Parte 2. Finalizado.");
		
		return "OK2";
	}

}
