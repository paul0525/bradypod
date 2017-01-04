package com.java.basic.tech;

import java.util.ArrayList;
import java.util.List;

/**
 * It shows a syntax of java. How to initialise the property of class, and it is
 * different from our normal cognition
 * 
 * @author paul
 *
 */
public class InstanceProperty {

	// it is block of class
	{
		System.out.println("InstanceProperty block_01....");
	}

	private List<String> list = new ArrayList<String>() {
		{ // this is a block of perperty
			System.out.println("I am in property  block....");
			add("block_01");
			add("block_02");
			add("block_03");

		}
	}; // pay attention to semicolon

	// it is block of class. Pay attention to sequence of execution
	{
		System.out.println("InstanceProperty block_02....");
	}

	public static void main(String args[]) {

		System.out.println("***** Test InstanceProperty begin *****");

		InstanceProperty test = new InstanceProperty();

		for (int i = 0, size = test.list.size(); i < size; i++) {
			System.out.println(test.list.get(i));
		}

		System.out.println("***** Test InstanceProperty end *****");
	}

}
