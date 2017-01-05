package com.java.basic.tech.thread;

import java.util.concurrent.Callable;

public class UserThread implements Callable<User> {
	

	public UserThread(User user) {
		super();
		this.user = user;
	}


	private User user;

	

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public User call() throws Exception {
		
		
		if(this.user == null )
			return null;
		
		this.user.setName(this.user.getName()+"_callable");
		
		return this.user;
	}

	

}
