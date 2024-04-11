package com.testnglisteners;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		//List will contains all the test cases that testng to execute.

		List<IMethodInstance> result =  new ArrayList<IMethodInstance>();
		result.add(methods.get(0));		
		return result;
	}
	
	
}
