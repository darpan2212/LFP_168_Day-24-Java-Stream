package com.bl.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
		streamMap();
		streamFilterData();
	}

	private static void streamFilterData() {
		System.out.println("_________Filter even numbers___________");
		Stream<Integer> intStream = intList.stream();

		Predicate<Integer> isEven = n -> n % 2 == 0;

		List<Integer> evenList = intStream.filter(isEven).collect(Collectors.toList());
		evenList.forEach(System.out::println);
	}

	private static void streamMap() {
		System.out.println("________map into doubleList_______");
		Stream<Integer> intStream = intList.stream();
		intStream.map(n -> n.doubleValue()).forEach(n -> {
			System.out.println("List with Mth3 : " + n);
		});
		List<Double> doubleList = new ArrayList<>();
		intStream = intList.stream();
		doubleList = intStream.map(n -> n.doubleValue()).collect(Collectors.toList());
		doubleList.stream().forEach(n -> {
			System.out.println("List with Mth4 : " + n);
		});
	}

	private static void streamForEach() {
		System.out.println("________intStream with foreach__________");
		Stream<Integer> intStream = intList.stream();
		intStream.forEach(n -> {
			System.out.println("List with Mth2 : " + n);
		});
	}

}