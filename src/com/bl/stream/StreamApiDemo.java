package com.bl.stream;

import java.util.ArrayList;
import java.util.Comparator;
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

		streamFindFirst();
		streamFindMax();
		streamFindMin();
		streamReduce();
	}

	private static void streamReduce() {
		System.out.println("_________Find Sum_________");

		long count = intList.stream().count();
		int sum = intList.stream().reduce(0, (n1, n2) -> n1 + n2);

		System.out.println("Sum of all numbers :" + sum);
		System.out.println("Total numbers : " + count);
		System.out.println("Avg of all numbers : " + ((double) sum / (double) count));

	}

	private static void streamFindMin() {
		System.out.println("_________Find Min_________");
		Stream<Integer> intStream = intList.stream();

		Predicate<Integer> isEven = n -> n % 2 == 0;

		Stream<Integer> evenNumStream = intStream.filter(isEven);
		Comparator<Integer> findMin = (num1, num2) -> num1 - num2;
		int maxEven = evenNumStream.min(findMin).get();
		System.out.println("Min even number :" + maxEven);
	}

	private static void streamFindMax() {
		System.out.println("_________Find Max_________");
		Stream<Integer> intStream = intList.stream();

		Predicate<Integer> isEven = n -> n % 2 == 0;

		Stream<Integer> evenNumStream = intStream.filter(isEven);
		Comparator<Integer> findMax = (num1, num2) -> num1 - num2;
		int maxEven = evenNumStream.max(findMax).get();
		System.out.println("Max even number :" + maxEven);
	}

	private static void streamFindFirst() {
		System.out.println("_________Find First_________");
		Stream<Integer> intStream = intList.stream();

		Predicate<Integer> isEven = n -> n % 2 == 0;

		Stream<Integer> evenNumStream = intStream.filter(isEven);
		int firstEven = evenNumStream.findFirst().get();
		System.out.println("First even number appeared is :" + firstEven);
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