package com.cff.staticblocks;

import java.util.HashMap;

public class Runner {
	
	private static String a = "CFF";
	
	private static HashMap<String,String> map = new HashMap<>();
	
	//eager initialization
	//We can have multiple static blocks
	static {
		map.put("name", "sandeep");
	}

	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(map);
	}

}
