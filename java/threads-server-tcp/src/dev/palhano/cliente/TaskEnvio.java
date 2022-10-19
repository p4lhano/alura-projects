package dev.palhano.cliente;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskEnvio implements Runnable {
	
	private Socket socket;

	public TaskEnvio(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			OutputStream EnviaOutputStream = socket.getOutputStream();
			PrintStream ps = new PrintStream(EnviaOutputStream);
			System.out.println("Preparando envio de dados");
			
			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if(line.trim().equals(""))
					break;
				ps.println(line);
			}
			scanner.close();						
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
