package com.qa.main;

public class Runner {

	public static void main(String[] args) {
		BetterNumberNamer test = new BetterNumberNamer();
		long Num = 1112171112524626211l;
		int length = (test.howLong(Num));

//		System.out.println(length + "\n");

		int[] Split = test.splitIntoArray(Num, length);

//		for (int i = 0; i < length + 3; i++) {
//			System.out.print(Split[i] + " ");
//		}
//		System.out.println("\n");

		test.nameThatNumber(Split, length);
	}
}
