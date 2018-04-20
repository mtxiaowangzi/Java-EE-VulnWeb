package com.eveino.utils;

import java.security.SecureRandom;

public class WebUtils {
	public static int generateID() {
		SecureRandom secureRandom = new SecureRandom();
		return Math.abs(secureRandom.nextInt());
	}
}
