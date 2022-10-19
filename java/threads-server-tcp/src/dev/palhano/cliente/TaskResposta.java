package dev.palhano.cliente;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskResposta implements Runnable {
	
	private Socket socket;

	public TaskResposta(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream reponseServer = socket.getInputStream();
			Scanner scannerInput = new Scanner(reponseServer);
			System.out.println("Escutando respotas do servidor");
			while (scannerInput.hasNext()) {
				System.out.println(scannerInput.nextLine());
			}
			scannerInput.close();						
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
