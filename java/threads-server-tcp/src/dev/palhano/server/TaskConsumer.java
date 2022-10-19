package dev.palhano.server;

import java.util.concurrent.BlockingQueue;

public class TaskConsumer implements Runnable {

	private BlockingQueue<String> filaComandos;
	
	public TaskConsumer(BlockingQueue<String> filaComandos) {
		this.filaComandos = filaComandos;
	}

	@Override
	public void run() {
		try {
			String msg =null;
			
			while ((msg = this.filaComandos.take()) != null) {
				System.out.println("Inicio processamento: "+msg+" T:" + Thread.currentThread().getName());
				
				Thread.sleep(5000);
				
				System.out.println("Terminado o processamento: "+msg+" T:" + Thread.currentThread().getName());				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
