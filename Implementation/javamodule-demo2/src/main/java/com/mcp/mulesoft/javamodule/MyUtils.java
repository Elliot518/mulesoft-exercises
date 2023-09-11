package com.mcp.mulesoft.javamodule;

public class MyUtils {
	public static String reformat(String input) {
		return String.format("Your Score is: %s", input.toUpperCase()); 
	}
}
