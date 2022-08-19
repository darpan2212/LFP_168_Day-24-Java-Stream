package com.bl.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiDemo {
	static List<Integer> intList;

	public static void main(String[] args) {

		intList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int random = (int) (Math.random() * 899 + 100);
			intList.add(random);
		}

		intList.forEach(n -> {
			System.out.println("List with Mth1 : " + n);
		});
		streamForEach();

	}

	private static void streamForEach() {
		System.out.println("________intStream with foreach__________");
		Stream<Integer> intStream = intList.stream();
		intStream.forEach(n -> {
			System.out.println("List with Mth2 : " + n);
		});
	}

}