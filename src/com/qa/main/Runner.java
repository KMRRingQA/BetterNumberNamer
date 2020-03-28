package com.qa.main;

public class Runner {

	public static void main(String[] args) {

		ChunkCounter chunkCounter = new ChunkCounter();
		String numString = "-123412341234134";
		chunkCounter.chunker(numString);
	}
}
