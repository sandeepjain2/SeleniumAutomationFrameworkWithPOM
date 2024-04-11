package com.assertj;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.testng.annotations.Test;

public class AssertDemo {

	//@Test
	public void stringTest() {
		String temp = "Hello World";

		//		String a ="";
		//		String b = "   ";

		Assertions.assertThat(temp)
		.as("String is null").isNotNull()
		.as("String is empty").isNotEmpty()
		.as("String is blank").isNotBlank()
		.as("String is not equal").isEqualTo("Hello World")
		.as("String does not contain").contains("Hello")
		.as("String contains").doesNotContain("Hi")
		.as("String doesn't contain").containsWhitespaces()
		.as("String doesn't contain").containsIgnoringCase("world")
		.as("String is not matching").matches("\\w.*" + " World")
		.as("String doesn't contains pattern").doesNotContainPattern("\\d.*")
		.as("String size is not matching").hasSize(11)
		.as("String size is lesser").hasSizeGreaterThan(10)
		.as("String size is greater").hasSizeLessThan(20)
		.as("String size is not in between").hasSizeBetween(10, 20)
		.as("String is not ending with").endsWith("World");		
	}

	//@Test
	public void numberTest() {
		int a = 10;

		Assertions.assertThat(a)
		.isEqualTo(10)
		.isBetween(5, 15)
		.isCloseTo(14, Offset.offset(5));	 

	}

	//@Test
	public void listTest() {
		List <String> list1 = Arrays.asList("Sandeep", "Jain");
		List <String> list2 = Arrays.asList("Selenium", "Testing");
		List <String> list3 = Arrays.asList("Manual", "Testing");

		Assertions.assertThat(list1)
		.hasSize(2)
		.hasSizeBetween(2, 15)
		.hasAtLeastOneElementOfType(String.class);

	}

	@Test
	public void mapTest() {
		HashMap<String, String> map = new HashMap<>();

		map.put("name", "Sandeep");

		Assertions.assertThat(map)
		.hasSize(1)
		.isNotEmpty();

	}




}
