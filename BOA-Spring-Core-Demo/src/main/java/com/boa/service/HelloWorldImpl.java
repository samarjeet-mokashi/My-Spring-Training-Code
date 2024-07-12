package com.boa.service;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public String printDetails(String name) {
		
		System.out.println("");
		
		return "Hello print my name" + name;
		
	}

}
