package com.qa.main;

public class Runner {

	public static void main(String[] args) {
		BetterNumberNamer numberNamer = new BetterNumberNamer();
		long num = 8223372036854775806L;
		int length = (numberNamer.howLong(num));

//		System.out.println(length + "\n");

		int[] split = numberNamer.splitIntoArray(num, length);

//		for (int i = 0; i < length; i++) {
//			System.out.print(Split[i] + " ");
//		}
//		System.out.println("\n");

		numberNamer.nameThatNumber(split, length);
	}
}
