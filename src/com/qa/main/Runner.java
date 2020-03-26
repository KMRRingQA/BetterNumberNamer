package com.qa.main;

public class Runner {

	public static void main(String[] args) {
		BetterNumberNamer numberNamer = new BetterNumberNamer();
		long Num = 5055055555311246566L;
		int length = (numberNamer.howLong(Num));

//		System.out.println(length + "\n");

		int[] Split = numberNamer.splitIntoArray(Num, length);

//		for (int i = 0; i < length; i++) {
//			System.out.print(Split[i] + " ");
//		}
//		System.out.println("\n");

		numberNamer.nameThatNumber(Split, length);
	}
}
