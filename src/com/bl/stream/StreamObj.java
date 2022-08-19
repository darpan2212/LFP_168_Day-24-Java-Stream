package com.bl.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamObj {

	public static void main(String[] args) {

		String[] students = { "Jack", "Mike", "Elena", "Stephan" };

		int option = 0;
		Stream<String> strStream;

		switch (option) {

		case 0:
			strStream = Arrays.stream(students);
			break;

		case 1:
			List<String> studentList = Arrays.asList(students);
			strStream = studentList.stream();
			break;

		case 2:
			strStream = Stream.of(students);
			break;

		case 3:
			Stream.Builder<String> streamBuilder = Stream.builder();
			for (String stu : students) {
				streamBuilder.accept(stu);
			}
			strStream = streamBuilder.build();
			break;

		}

	}

}