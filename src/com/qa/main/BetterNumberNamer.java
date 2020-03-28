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

	public int[] intToArray(int num) {
		int[] triplet = new int[3];

		for (int i = 0; i < 3; i++) {
			int digit = num;
			triplet[i] = (int) (digit / Math.pow(10, i)) % 10;
		}
		return triplet;
	}

	public void nameThatNumber(int[] triplet, int superPower) {
		int skip = 0;
		if (triplet[2] == 0 && triplet[1] == 0 && triplet[0] == 0) {
			skip = 1;
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
		if (skip == 0) {
			System.out.print(" " + powersName[superPower] + " ");
		}

	}
}
