package com.java.basic.tech.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * It prints callable thread.
 * 
 * @author paul
 *
 */
public class UserResultThread extends Thread {

	public UserResultThread(ExecutorService service,
			List<Future<User>> futueList) {
		super();
		this.service = service;
		this.futueList = futueList;
	}

	List<Future<User>> futueList;

	private ExecutorService service;

	public void run() {

		System.out.println("User Result Thread is starting......");

		if (this.service == null || this.futueList == null
				|| this.futueList.size() <= 0) {
			System.out.println("User Result Thread is end......");
			return;
		}

		for (Future<User> ut : this.futueList) {

			try {

				System.out.println("result:" + ut.get().getName());
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}
		}

		// close the thread pool
		this.service.shutdown();

		System.out.println("User Result Thread is ending......");
	}

}
