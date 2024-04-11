package com.dataprovider.latest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvideWithJSon {

	@Test(dataProvider = "getExcelJSonObjects")
	public void testDataProviderWithJson(Map <String, Object> map) {
		map.forEach((k,v) -> System.out.println(k + ":" + v));
	}

	@DataProvider
	public Object[] getExcelJSonObjects() throws Throwable {

		HashMap<String, Object> map1 = new ObjectMapper()
				.readValue(new File(System.getProperty("user.dir")+ "/JSon/config.json"), 
						new TypeReference<HashMap<String,Object>>() {});

		return new Object[] {map1};

	}
}