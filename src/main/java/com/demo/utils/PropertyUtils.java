package com.demo.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.demo.constants.FrameworkConstants;
import com.demo.enums.ConfigProperties;


public final class PropertyUtils {

	private PropertyUtils() {


	}
	private static Properties property = new Properties();

	static {
		
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getCONFIGFILEPATH());
			property.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


	}

	public static String getValue(ConfigProperties key) throws Exception {
		
		if(Objects.isNull(key)||Objects.isNull(key)) {
			throw new Exception("Propery name " + key +" is not found.Please check config.properties");
		}
		return property.getProperty(key.name().toLowerCase());
	}

}
