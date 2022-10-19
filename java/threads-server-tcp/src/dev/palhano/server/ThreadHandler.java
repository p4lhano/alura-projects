package dev.palhano.server;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("Error em " + t.getName() + ", by " + e.getMessage());

	}

}
