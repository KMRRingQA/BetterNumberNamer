package com.qa.main;

public class BetterNumberNamer {

	final private String[] unitName = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	final private String[] deciName = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	final private String[] powersName = { "", "", "", "thousand", "thousand", "thousand", "million", "million",
			"million", "billion", "billion", "billion", "trillion", "trillion", "trillion", "quadrillion",
			"quadrillion", "quadrillion", "quintillion", "quintillion", "quintillion", "sextillion", "sextillion",
			"sextillion" };

	public int howLong(long num) {
		int length = 0;
		for (long i = 1; i <= num; i *= 10) {
			length++;
		}
		return length;
	}

	public void nameThatNumber(int[] split, int length) {
		int digitMultiplier = length / 3 + 1;
		while (digitMultiplier > 0) {
			int units = 3 * digitMultiplier - 3;
			int tens = 3 * digitMultiplier - 2;
			int hundreds = 3 * digitMultiplier - 1;
			int skip = 0;
			if (split[tens] == 0 && split[units] == 0 && split[hundreds] == 0) {
				skip = 1;
			} else if (split[hundreds] == 0) {
				if (split[tens] < 2) {
					System.out.print(unitName[split[tens] * 10 + split[units]]);
				} else if (split[units] == 0) {
					System.out.print(deciName[split[tens]]);
				} else {
					System.out.print(deciName[split[tens]] + "-" + unitName[split[units]]);
				}
			} else if (split[tens] == 0 && split[units] == 0) {
				System.out.print(unitName[split[hundreds]] + " hundred");
			} else if (split[tens] < 2) {
				System.out
						.print(unitName[split[hundreds]] + " hundred and " + unitName[split[tens] * 10 + split[units]]);
			} else if (split[units] == 0) {
				System.out.print(unitName[split[hundreds]] + " hundred and " + deciName[split[tens]]);
			} else {
				System.out.print(unitName[split[hundreds]] + " hundred and " + deciName[split[tens]] + "-"
						+ unitName[split[units]]);
			}
			if (length >= 3 && skip == 0) {
				System.out.print(" " + powersName[length] + " ");
			}
			digitMultiplier--;
			length -= 3;
		}
	}

	public int[] splitIntoArray(long num, int length) {
		int[] split = new int[length + 3];

		for (long i = 0; i < length; i++) {
			long digit = num;
			for (int j = 0; j < i; j++) {
				digit /= 10;
			}
			digit = digit % 10;
//		long digit = (long) ((Num / (Math.pow(10l, i))) % 10l);
// 		this does not work as Math.pow works with type double, which is less precise in the mantissa (52 bits) than
// 		a long (62 bits)
			int intDigit = (int) digit;
			int j = (int) i;
			split[j] = intDigit;
		}
		return split;
	}
}
