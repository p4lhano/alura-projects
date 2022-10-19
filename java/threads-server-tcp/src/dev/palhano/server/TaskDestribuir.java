package dev.palhano.server;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskDestribuir implements Runnable {

	private Socket socket;
	private Server server;

	public TaskDestribuir(Socket accept,Server server) {
		this.socket = accept;
		this.server = server;
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
					break;
				case "c2":
					saidaForCliente.println("Confirmado "+msg);
					break;
				case "c3":
					saidaForCliente.println("Confirmado "+msg);
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
