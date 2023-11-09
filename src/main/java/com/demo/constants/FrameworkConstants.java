package com.demo.constants;

public class FrameworkConstants {
	
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources/";
	private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
	private static final int EXPLICITWAIT=20;

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getCONFIGFILEPATH() {
		return CONFIGFILEPATH;
	}

	public static String getCHROMEDRIVERPATH() {
		return CHROMEDRIVERPATH;
		
	}

	
}
