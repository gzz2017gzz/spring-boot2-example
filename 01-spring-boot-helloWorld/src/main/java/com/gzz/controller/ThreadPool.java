package com.gzz.controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(4));
		saldfjasfd:
		for (int i = 1; i < 10; i++)
			executor.execute(() -> {
				try {

					System.out.println(Thread.currentThread().getName());
					TimeUnit.MINUTES.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}

}
