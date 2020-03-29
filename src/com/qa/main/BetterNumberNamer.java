package com.qa.main;

public class BetterNumberNamer {

	final private String[] unitName = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	final private String[] deciName = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	final private String[] powersName = { "", "", "thousand", "million", "billion", "trillion", "quadrillion",
			"quintillion", "sextillion", "septillion", "octillion", "nonillion", "decillion", "undecillion",
			"duodecillion", "tredecillion", "quattuordecillion", "quindecillion", "sexdecillion", "septendecillion",
			"octodecillion", "novemdecillion", "vigintillion", "unvigintillion", "duovigintillion", "trevigintillion",
			"quattuorvigintillion", "quinvigintillion", "sexvigintillion", "septenvigintillion", "octovigintillion",
			"nonvigintillion", "trigintillion", "untrigintillion", "duotrigintillion" };

	public void chunker(String numString) {
		int length = numString.length();
		int tripletNumber = 0;
		String tripletString = "";
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
		tripletNumber = length / 3;
		int initialTripletNumber = tripletNumber;
		for (int i = 0; i < initialTripletNumber; i++) {
			tripletString = numString.substring(3 * i, 3 * i + 3);
			int[] tripletIntArray = this.stringToIntArray(tripletString);
			this.nameThatNumber(tripletIntArray, tripletNumber);
			tripletNumber--;
		}
	}

	public void nameThatNumber(int[] triplet, int tripletNumber) {
		if (triplet[2] == 0 && triplet[1] == 0 && triplet[0] == 0) {
			return;
		} else if (triplet[2] == 0) {
			if (triplet[1] < 2) {
				System.out.print(unitName[triplet[1] * 10 + triplet[0]]);
			} else if (triplet[0] == 0) {
				System.out.print(deciName[triplet[1]]);
			} else {
				System.out.print(deciName[triplet[1]] + "-" + unitName[triplet[0]]);
			}
		} else if (triplet[1] == 0 && triplet[0] == 0) {
			System.out.print(unitName[triplet[2]] + " hundred");
		} else if (triplet[1] < 2) {
			System.out.print(unitName[triplet[2]] + " hundred and " + unitName[triplet[1] * 10 + triplet[0]]);
		} else if (triplet[0] == 0) {
			System.out.print(unitName[triplet[2]] + " hundred and " + deciName[triplet[1]]);
		} else {
			System.out
					.print(unitName[triplet[2]] + " hundred and " + deciName[triplet[1]] + "-" + unitName[triplet[0]]);
		}
		System.out.print(" " + powersName[tripletNumber] + " ");

	}

	public int stringToInt(String tripletString) {
		int tripletInt = Integer.parseInt(tripletString);
		return tripletInt;
	}

	public int[] stringToIntArray(String tripletString) {
		int tripletInt = Integer.parseInt(tripletString);
		int[] tripletIntArray = new int[3];

		for (int i = 0; i < 3; i++) {
			tripletIntArray[i] = (int) (tripletInt / Math.pow(10, i)) % 10;
		}
		return tripletIntArray;
	}
}
