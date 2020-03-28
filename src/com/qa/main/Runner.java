package com.qa.main;

public class Runner {

	public static void main(String[] args) {

		ChunkCounter chunkCounter = new ChunkCounter();
		String numString = "1110225524534615363614352423874223400024410";
		chunkCounter.chunker(numString);
	}
}
