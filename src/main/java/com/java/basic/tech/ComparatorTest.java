package com.java.basic.tech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author paul
 *
 */
public class ComparatorTest {

	
	private List<User> listUsers = new ArrayList<User>(){{
		add(new User("cUser",18));
		add(new User("aUser",19));
		add(new User("aUser",20));
		add(new User("bUser",20));
	}};
	
	
	public static void main(String args[]){
		
		ComparatorTest comparatorTest = new ComparatorTest();
		
		Collections.sort( comparatorTest.listUsers,  new Comparator<User>(){
			@Override
			public int compare(User u1, User u2) {
				
				if( u1.getName().compareTo(u2.getName()) == 0){
					return u1.getAge() - u2.getAge();
				}
				
				return u1.getName().compareTo(u2.getName());
			}
		} );
		
		
		System.out.println("[Collection.sort]");
		for( ComparatorTest.User u : comparatorTest.listUsers ){
			System.out.println( String.format("%s-%d", u.getName(), u.getAge() ));
		}
		
		System.out.println();
		
		ComparatorTest.User user =  comparatorTest.new User("cUser",18);
		
		if( user.equals(comparatorTest.listUsers.get(3) ) )
			System.out.println("yes, it is equals");
		
		
		//revert
		System.out.println();
		System.out.println("[Collection revert]");
		Collections.reverse(comparatorTest.listUsers  );
		for( ComparatorTest.User u : comparatorTest.listUsers ){
			System.out.println( String.format("%s-%d", u.getName(), u.getAge() ));
		}
		
		
	}
	
	
	public class User{
		
		public User(){}
		
		public User(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		private String name;
		
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object obj) {
			
			if( !(obj instanceof User )) return false;
			
			User user = (User)obj;
			
			if( this.age == user.getAge() && this.name.equals( user.getName() )){
				return true;
			}else{
				return false;
			}
		}
		
	}/* inner class User*/
	
}
