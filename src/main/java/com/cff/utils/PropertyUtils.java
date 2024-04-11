package com.cff.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.chrome.AddHasCasting;

import com.cff.constants.FrameworkConstants;
import com.cff.enums.ConfigProperties;
import com.google.common.collect.Multiset.Entry;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFNIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fis);

//			for (Object key : prop.keySet()) {
//				CONFNIGMAP.put(String.valueOf(key), String.valueOf(prop.get(key)));					
//			}
			
	//OR can use below option
			
//			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
//				CONFNIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
//			}
			
	//OR can use below option
			
			prop.entrySet().forEach(entry -> CONFNIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim()));

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}		
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	//hashtbale is little slow but hread safe... //hashmap

	//converting a property file to hashmap needs sometime. and when we are fetching some value from property file at a time

//	public static String getValueByHashmap(String key) throws Exception {
//		if(Objects.isNull(key) || Objects.isNull(CONFNIGMAP.get(key))) {
//			throw new Exception("Property name : " + key + " is not found, please check config.properties file.");			
//		}
//		return CONFNIGMAP.get(key);
//	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static String getValueByHashmap(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFNIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property name : " + key + " is not found, please check config.properties file.");			
		}
		return CONFNIGMAP.get(key.name().toLowerCase());
	}


//	public static String getValue(String key) throws Exception {
//
//		if(Objects.isNull(prop.getProperty(key)) || Objects.isNull(key)) {
//			throw new Exception("Property name : " + key + " is not found, please check config.properties file.");
//		}
//		return prop.getProperty(key);			
//	}	

}
