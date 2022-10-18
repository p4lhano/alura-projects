package dev.palhano.threads;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main");
		Thread.sleep(5000); //milissegundos (5 * 1000 = 5s)
		
		System.out.println("Main 2");
	}
}
