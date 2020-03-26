package com.qa.main;

public class Runner {

	public static void main(String[] args) {
		BetterNumberNamer test = new BetterNumberNamer();
		int Num = 1860003566;
		int length = (test.howLong(Num));

//		System.out.println(length + "\n");

		int[] Split = test.splitIntoArray(Num, length);

//		for (int i = 0; i < length + 3; i++) {
//			System.out.println(Split[i]);
//		}

		test.nameThatNumber(Split, length);
	}
}
