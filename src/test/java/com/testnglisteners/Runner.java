package com.testnglisteners;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner {
	
	@BeforeSuite
	public void setUpSuite() {System.out.println("before suite in runner");}
	
	@AfterSuite
	public void tearDownSuite() {System.out.println("after suite in runner");}
	
	@BeforeMethod
	public void setUpe() {System.out.println("before method in runner");}
	
	@AfterMethod
	public void tearDown() {System.out.println("after method in runner");}
	
	@Test
	public void test1() {System.out.println("test1");}
	
	@Test
	public void test2() {System.out.println("test2");}
	
	@Test
	public void test3() {System.out.println("test3");}
	

}
