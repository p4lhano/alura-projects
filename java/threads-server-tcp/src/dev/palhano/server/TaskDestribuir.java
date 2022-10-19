package dev.palhano.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

import dev.palhano.server.comands.ComandoC1;
import dev.palhano.server.comands.ComandoC2;
import dev.palhano.server.comands.ComandoC3;

public class TaskDestribuir implements Runnable {

	private Socket socket;
	private Server server;
	private ExecutorService threadsPool;

	public TaskDestribuir(Socket accept,Server server, ExecutorService threadsPool) {
		this.socket = accept;
		this.server = server;
		this.threadsPool = threadsPool;
	}

	@Override
	public void run() {
		System.out.println("Distribuiu uma task S:" + socket + " T:" + Thread.currentThread().getName());
		
		try (Scanner scannerCliente = new Scanner(socket.getInputStream())) {
			
			PrintStream saidaForCliente = new PrintStream( socket.getOutputStream());
			while (scannerCliente.hasNextLine()) {
				
				String msg = scannerCliente.nextLine();
				System.out.println("C:" + msg);
				
				
				switch (msg.toLowerCase()) {
				case "c1":
					saidaForCliente.println("Confirmado "+msg);
					ComandoC1 c1 = new ComandoC1(saidaForCliente);
					threadsPool.execute(c1);
					break;
				case "c2":
					saidaForCliente.println("Confirmado "+msg);
					ComandoC2 c2 = new ComandoC2(saidaForCliente);
					threadsPool.execute(c2);
					break;
				case "c3":
					saidaForCliente.println("Confirmado "+msg);
					ComandoC3 c3 = new ComandoC3(saidaForCliente);
					threadsPool.execute(c3);
					break;
				case "c9":
					saidaForCliente.println("Confirmado "+msg);
					saidaForCliente.println("Desligando servidor");
					this.server.shutdown();
					break;

				default:
					saidaForCliente.println("não encontrado co:"+msg);
					break;
				}
			}
		

			saidaForCliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
