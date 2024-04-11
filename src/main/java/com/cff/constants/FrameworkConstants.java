package com.cff.constants;

public final class FrameworkConstants {

	private FrameworkConstants(){

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/Executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/config/config.json";
	private static final int EXPLICITWAIT = 10;

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
	
}
