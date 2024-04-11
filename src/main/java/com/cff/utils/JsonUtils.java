package com.cff.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.cff.constants.FrameworkConstants;
import com.cff.enums.ConfigProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	private static Map<String,Object> CONFNIGMAP;

	private JsonUtils() {

	}	

	static {
		try {
			CONFNIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonConfigFilePath()),	new TypeReference<HashMap<String, Object>>() {});

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}		
		catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public static String getValueByHashmapUsingJson(ConfigProperties key) throws Exception {
		if(Objects.isNull(key) || Objects.isNull(CONFNIGMAP.get(key.name().toLowerCase()))){
			throw new Exception("Property name : " + key + " is not found, please check config.properties file.");			
		}
		return (String) CONFNIGMAP.get(key.name().toLowerCase());
	}

}
