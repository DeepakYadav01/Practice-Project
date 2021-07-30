package com.nagarro.telecompractice.utils;

import java.util.Random;

public class RandomPasswordGenerator {

	public static String generatePassword() {
		
		final int passwordLength = 8;
		final String values = Constants.CAPITAL_CHARS + Constants.SMALL_CHARS + Constants.NUMBERS + Constants.SYMBOLS;

		Random random = new Random();

		StringBuilder password = new StringBuilder();

		for (int i = 0; i < passwordLength; i++) {

			password.append(values.charAt(random.nextInt(values.length())));

		}
		return password.toString();
	}
}
