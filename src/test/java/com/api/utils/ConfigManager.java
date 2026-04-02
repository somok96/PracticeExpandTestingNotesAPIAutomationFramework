package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private ConfigManager() {
		
	}
	
	
	private static Properties prop = new Properties();
	private static String path = "config/config.qa.properties";
	private static String env;

	static {

		env = System.getProperty("env", "qa");
		env = env.trim().toLowerCase();

		switch (env) {

		case "qa" -> path = "config/config.qa.properties";
		case "dev" -> path = "config/config.qa.properties";
		case "uat" -> path = "config/config.qa.properties";
		default -> path = "config/config.qa.properties";

		}

		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

		try {
			prop.load(input);
		} catch (IOException e) {

			throw new IllegalArgumentException("File not found...");
		}

	}

	public static String getProperty(String key) {

		return prop.getProperty(key);

	}

}
