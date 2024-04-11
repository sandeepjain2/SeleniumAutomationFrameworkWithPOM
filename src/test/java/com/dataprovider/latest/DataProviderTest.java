package com.dataprovider.latest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderTest {

	//@Test
	public void Test() {

		String[] a = {"Sandeep", "Sandeep", "Sandeep"};
		for (int i = 0; i<a.length; i++) {
			System.out.println("Sandeep");
			System.out.println("Jain");
			System.out.println("Shahpur");

			Assert.assertTrue(false);
		}		
	}


	//@Test(dataProvider = "getData")
	public void Test1(String username) {
		System.out.println("Sandeep");
		System.out.println("Jain");
		System.out.println("Shahpur");

		Assert.assertTrue(true);

	}


	//@DataProvider
	public String[] getData() {

		String[] a = {"Sandeep", "Jain", "Shahpur"};
		return a;			
	}


	//@Test(dataProvider = "getData1")
	public void Test2(String username) {
		System.out.println("Sandeep");
		System.out.println("Jain");
		System.out.println("Shahpur");

		Assert.assertTrue(true);
	}

	/*
	 * 2D object array is not always the return type of data provider
	 * 
	 */


	//		Object[1st dimension][2nd dimension]  --- > 
	//		1st dimension, how many iteration you want to run this test
	//		2nd dimension, how many parameter you want to feed to your test method


	//@DataProvider
	public Object[][] getData1() {
		return new Object[][] {
			{"Sandeep"},
			{"Jain"},
			{"Shahpur"}	
		};
	}


	@Test(dataProvider = "getData3")
	public void test4(String username) {
		System.out.println("SAndeep");
		System.out.println("Jain");
	}

	@Test(dataProvider = "getData3")
	public void test5(Integer i) {
		System.out.println(1);

	}

	@DataProvider
	public Object[] getData3(Method m) {
		if(m.getName().equalsIgnoreCase("test4")) {
			return new Object[] {"SAndeep", "Jain"};
		}
		else if (m.getName().equalsIgnoreCase("test5")) {
			return new Object[] {1};
		}
		return null;		
		
	}















}
