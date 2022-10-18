package dev.palhano.server;

import java.net.Socket;
import java.util.Scanner;

public class TaskDestribuir implements Runnable {

	private Socket socket;

	public TaskDestribuir(Socket accept) {
		this.socket = accept;
		
	}

	@Override
	public void run() {
		System.out.println("Distribuiu uma task S:" + socket + " T:" + Thread.currentThread().getName());
		
		try (Scanner scannerCliente = new Scanner(socket.getInputStream())) {
			
			while (scannerCliente.hasNextLine()) {
				String msg = scannerCliente.nextLine();
				System.out.println(msg);
			}
		

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
