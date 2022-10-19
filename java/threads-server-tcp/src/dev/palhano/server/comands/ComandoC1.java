package dev.palhano.server.comands;

import java.io.PrintStream;

public class ComandoC1 implements Runnable {

	private PrintStream cliente;

	public ComandoC1(PrintStream saidaForCliente) {
		this.cliente = saidaForCliente;

	}

	@Override
	public void run() {
		try{
			System.out.println("Runnabled c1");
			
			Thread.sleep(3000);
			
			cliente.println("Executado c1. Finalizado.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
