package dev.palhano.server;

public class ThreadFactory implements java.util.concurrent.ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setUncaughtExceptionHandler(new ThreadHandler());
		return thread;
	}

}
