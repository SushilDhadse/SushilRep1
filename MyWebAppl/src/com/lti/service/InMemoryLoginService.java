package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {

	private HashMap<String, String> users = new HashMap<>();

	public InMemoryLoginService() {
		users.put("sushil", "123");
		users.put("akki", "321");
		users.put("crybaby", "111");
		users.put("crybaba", "999");
	}

	public boolean isValidUser(String username, String password) {
		if (users.containsKey(username))
			if (users.get(username).equals(password))
				return true;
				return false;
	}
}
