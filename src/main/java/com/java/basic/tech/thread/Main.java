package com.java.basic.tech.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * It shows how to use future and callable.
 * @author paul
 *
 */

public class Main {

	
	
	public static void main( String args[]){
		
		//initialize users
		List<User> listUser = getListUser();
		
		//initialize the callable thread
		List<UserThread> threadList = new ArrayList<UserThread>();
		
		for( User user : listUser ){
			threadList.add( new UserThread(user));
		}
		
		
		//make a excutor of  thread pool
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		// list of result  of thread
		List<Future<User>> futueList = new ArrayList<Future<User>>();

		for( UserThread  th  : threadList ){
			
			//It submits the callable thread, and callable thread will execute.
			futueList.add(exec.submit( th ));               
		}
		
		//use a thread to print the result of callabel thread.
		new UserResultThread( exec, futueList).start();
		
	}
	
	
	private static List<User> getListUser() {
		
		List<User> rel = new ArrayList<User>();
		
		rel.add(new User("dzg",18));
		rel.add(new User("paul",24));
		rel.add(new User("dong",23));
		rel.add(new User("zhi",21));
		rel.add(new User("guo",20));
		
		return rel;
	}
}
