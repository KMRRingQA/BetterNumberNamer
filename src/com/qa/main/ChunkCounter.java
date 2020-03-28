package com.qa.main;

public class ChunkCounter {
	public void chunker(String numString) {
		BetterNumberNamer betterNumberNamer = new BetterNumberNamer();
		int length = numString.length();
		int superPower = 0;
		String stringChunk = "";
		if (numString.equals("0") || numString.equals("-0")) {
			System.out.print("zero");
			return;
		}
		if (length > 102) {
			System.out.print("There is no systematic name for your number.");
			return;
		}
		if (numString.substring(0, 1).equals("-")) {
			System.out.print("negative ");
			numString = numString.substring(1, length);
			length--;
		}
		if (length % 3 == 1) {
			numString = "00" + numString;
			length += 2;
		} else if (length % 3 == 2) {
			numString = "0" + numString;
			length++;
		}
		superPower = length / 3;
		int initialPower = superPower;
		for (int i = 0; i < initialPower; i++) {
			stringChunk = numString.substring(3 * i, 3 * i + 3);
			int stringToInt = Integer.parseInt(stringChunk);
			int[] triplet = betterNumberNamer.intToArray(stringToInt);
			betterNumberNamer.nameThatNumber(triplet, superPower);
			superPower--;
		}
	}
}