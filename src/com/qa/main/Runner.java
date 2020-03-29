package com.qa.main;

public class Runner {

	public static void main(String[] args) {

		BetterNumberNamer numberNamer = new BetterNumberNamer();
		String numString = "-17858765000";
		numberNamer.chunker(numString);
	}
}
