package com.gill;

import java.util.HashMap;
import java.util.Map;

public class Maps {

	public static void main(String[] args) {
		Map<String,String> languages = new HashMap<>();
		
		languages.put("Java", "OOPS");
		languages.put("Python", "Interpreted");
		languages.put("Algol", "Algorithm lang");
		languages.put("BASIC", "beginers");
		languages.put("LISP", "madnesss");
		
		System.out.println(languages.get("Java"));
	}

}
