package com.qa.main;

public class BetterNumberNamer {

	final private String[] unitName = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	final private String[] deciName = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	final private String[] powersName = { "", "", "", "thousand", "thousand", "thousand", "million", "million",
			"million", "billion", "billion", "billion", "trillion", "trillion", "trillion", "quadrillion",
			"quadrillion", "quadrillion", "quintillion", "quintillion", "quintillion", };

	public int howLong(long Num) {
		int length = 0;
		for (long i = 1; i <= Num; i *= 10) {
			length++;
		}
		return length;
	}

	public void nameThatNumber(int[] Split, int length) {
		int DigitMultiplier = length / 3 + 1;
		while (DigitMultiplier > 0) {
			int units = 3 * DigitMultiplier - 3;
			int tens = 3 * DigitMultiplier - 2;
			int hundreds = 3 * DigitMultiplier - 1;
			int skip = 0;
			if (Split[tens] == 0 && Split[units] == 0 && Split[hundreds] == 0) {
				skip = 1;
			} else if (Split[hundreds] == 0) {
				if (Split[tens] < 2) {
					System.out.print(unitName[Split[tens] * 10 + Split[units]]);
				} else if (Split[units] == 0) {
					System.out.print(deciName[Split[tens]]);
				} else {
					System.out.print(deciName[Split[tens]] + "-" + unitName[Split[units]]);
				}
			} else if (Split[tens] == 0 && Split[units] == 0) {
				System.out.print(unitName[Split[hundreds]] + " hundred");
			} else if (Split[tens] < 2) {
				System.out
						.print(unitName[Split[hundreds]] + " hundred and " + unitName[Split[tens] * 10 + Split[units]]);
			} else if (Split[units] == 0) {
				System.out.print(unitName[Split[hundreds]] + " hundred and " + deciName[Split[tens]]);
			} else {
				System.out.print(unitName[Split[hundreds]] + " hundred and " + deciName[Split[tens]] + "-"
						+ unitName[Split[units]]);
			}
			if (length >= 3 && skip == 0) {
				System.out.print(" " + powersName[length] + " ");
			}
			DigitMultiplier--;
			length -= 3;
		}
	}

	public int[] splitIntoArray(long Num, int length) {
		int[] Split = new int[length + 3];

		for (int i = 0; i < length; i++) {
			int digit = (int) ((Num / (Math.pow(10, i))) % 10);
			Split[i] = digit;
		}
		for (int i = length; i < length + 3; i++) {
			Split[i] = 0;
		}
		return Split;
	}
}
