package dev.palhano.server;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TaskWaitResponseFuture implements Callable<Void> {

	private PrintStream saidaForCliente;
	private Future<String> future1;
	private Future<String> future2;

	public TaskWaitResponseFuture(PrintStream saidaForCliente, Future<String> future1, Future<String> future2) {
		this.saidaForCliente = saidaForCliente;
		this.future1 = future1;
		this.future2 = future2;
	}

	@Override
	public Void call() throws Exception {
		System.out.println("Aguando result p1 e p2");

		try {
			String resposta1 = this.future1.get(15, TimeUnit.SECONDS);
			String resposta2 = this.future2.get(15, TimeUnit.SECONDS);
			
			saidaForCliente.println("Resultado Sucess : " + resposta1 + "_" + resposta2);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(e.getMessage());
			saidaForCliente.println("Error : "+e.getMessage());
			future1.cancel(true);
			future2.cancel(true);
		}
		System.out.println("final TaskWaitResponseFuture.call()");
		return null;
	}

}
