package dev.palhano.server.comands;

import java.io.PrintStream;

public class ComandoC3 implements Runnable {

	private PrintStream cliente;

	public ComandoC3(PrintStream saidaForCliente) {
		this.cliente = saidaForCliente;

	}

	@Override
	public void run() {
		try{
			System.out.println("Runnabled c3");
			
			Thread.sleep(3000);
			
			cliente.println("Executado c3. Finalizado.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
