package com.zm.test;

import org.junit.Test;

public class StringT {

	@Test
	public void tt(){
	
		String s1 = "Programming";
		String s2 = new String("Programming");
		String s3 = "Program" + "ming";
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1 == s1.intern());
	}
	
	
	public static void main(String[] args) {

	}

}
