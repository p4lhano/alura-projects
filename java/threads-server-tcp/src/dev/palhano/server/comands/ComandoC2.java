package dev.palhano.server.comands;

import java.io.PrintStream;

public class ComandoC2 implements Runnable {

	private PrintStream cliente;

	public ComandoC2(PrintStream saidaForCliente) {
		this.cliente = saidaForCliente;

	}

	@Override
	public void run() {
		try{
			System.out.println("Runnabled c2");
			
			Thread.sleep(3000);
			
			cliente.println("Executado c2. Finalizado.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
