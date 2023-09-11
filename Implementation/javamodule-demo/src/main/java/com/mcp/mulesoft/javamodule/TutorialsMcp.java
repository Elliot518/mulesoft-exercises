package com.mcp.mulesoft.javamodule;

public class TutorialsMcp {
	
	public static int getAge(String name) {
		if (name.equals("TutorialsMcp")) {
			return 10;
		} else {
			return 3;
		}
	}
	
	public String getResult(int marks) {
		if (marks > 33) {
			return "Pass";
		} else {
			return "Fail";
		}
	}
}

