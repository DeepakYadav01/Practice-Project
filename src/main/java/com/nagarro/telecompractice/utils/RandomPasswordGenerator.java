package com.nagarro.telecompractice.utils;

import java.util.Random;

public class RandomPasswordGenerator {

	// A strong password has Cap_chars, Lower_chars,
	// numeric value and symbols. So i am using all of
	// them to generate our password
	private static final String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String Small_chars = "abcdefghijklmnopqrstuvwxyz";
	private static final String numbers = "0123456789";
	private static final String symbols = "!@#$%^&*_=+-/.?<>)";

	/*
	 * Returning 8 digit random generated password
	 */
	public static String generatePassword() {
		
		final int passwordLength = 8;
		final String values = Capital_chars + Small_chars + numbers + symbols;

		// Using random method
		Random random = new Random();

		StringBuilder password = new StringBuilder();

		for (int i = 0; i < passwordLength; i++) {

			password.append(values.charAt(random.nextInt(values.length())));

		}
		return password.toString();
	}
}
