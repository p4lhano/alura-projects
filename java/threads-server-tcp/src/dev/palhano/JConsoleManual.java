package dev.palhano;

import java.util.Set;

public class JConsoleManual {

	public static void main(String[] args) {
		Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();

		
		
		for (Thread thread : todasAsThreads) {
		    System.out.println(thread.getName());
		}
	}

}
