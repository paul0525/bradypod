package com.java.basic.tech;

/**
 * It shows switch fall through syntax
 * and it like goto statement
 * In Java SE 7 and later, you can use a String object in the switch statement's expression
 * @author paul
 *
 */
public class SwitchFallThrough {

	
	public static  void main(String args[]){
		
		System.out.println("a message:");
		dispatchMessage('a');
		
		System.out.println("");
		System.out.println("c message:");
		dispatchMessage('c');
		
		System.out.println("");
		System.out.println("d message:");
		dispatchMessage('d');
		
	}
	
	
	public static void  dispatchMessage( char msg ){
		
		switch( msg ){
		  case 'a':
		  case 'b':
//		  {                              
			  String name="paul";
			  prepareAOrB();
//		  }	  
		  case 'c':
//			  String name= "allen";    //syntax error: duplicate local variable name if there is no brace in line 24 and 27;
			  handleABOrC();
			  break;
		  case 'd':
			  handleD();
			  break;
		   
		}
	}


	private static void handleD() {

		System.out.println("hanlder d ");
	}


	private static void handleABOrC() {

		System.out.println("handle ab Or c ");
	}


	private static void prepareAOrB() {
		System.out.println("prepare a or b ");
	}
}
