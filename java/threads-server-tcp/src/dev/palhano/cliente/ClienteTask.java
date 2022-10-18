package dev.palhano.cliente;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import dev.palhano.server.ServerMain;

public class ClienteTask {

	public static void main(String[] args) {
		
		try( Socket socket = new Socket( "localhost" , ServerMain.PORT_SERVER )) {
			System.out.println("Conexão estabelecida");
			OutputStream outputStream = socket.getOutputStream();
			PrintStream ps = new PrintStream(outputStream);
			
			ps.println("{\"c1\":\"shutdown\"}");
			ps.println("{\"c2\":\"shutdown\"}");
			
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

}
