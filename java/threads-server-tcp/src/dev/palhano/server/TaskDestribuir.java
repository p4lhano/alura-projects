package dev.palhano.server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import dev.palhano.server.comands.ComandoC1;
import dev.palhano.server.comands.ComandoC2Part1;
import dev.palhano.server.comands.ComandoC2Part2;
import dev.palhano.server.comands.ComandoC3;
/**
 * Design pattern - FrontController
 * */
public class TaskDestribuir implements Runnable {

	private Socket socket;
	private Server server;
	private ExecutorService threadsPool;
	private BlockingQueue<String> filaComandos;

	public TaskDestribuir(Socket accept,Server server, ExecutorService threadsPool, BlockingQueue<String> filaComandos) {
		this.socket = accept;
		this.server = server;
		this.threadsPool = threadsPool;
		this.filaComandos = filaComandos;
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
					ComandoC2Part1 c2p1 = new ComandoC2Part1(saidaForCliente);
					ComandoC2Part2 c2p2 = new ComandoC2Part2(saidaForCliente);
					Future<String> future1 = threadsPool.submit(c2p1);
					Future<String> future2 = threadsPool.submit(c2p2);
					
					threadsPool.submit(new TaskWaitResponseFuture(saidaForCliente,future1,future2));
					
					break;
				case "c3":
					saidaForCliente.println("Confirmado "+msg+". Add para fila.");
					
					this.filaComandos.put(msg);
					
//					ComandoC3 c3 = new ComandoC3(saidaForCliente);
//					threadsPool.execute(c3);
					break;
				case "c9":
					saidaForCliente.println("Confirmado "+msg);
					saidaForCliente.println("Desligando servidor");
					this.server.shutdown();
					break;

				default:
					saidaForCliente.println("n??o encontrado co:"+msg);
					break;
				}
			}
		

			saidaForCliente.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
