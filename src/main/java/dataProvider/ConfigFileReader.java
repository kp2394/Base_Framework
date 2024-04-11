package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//config.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				
				properties.load(reader);
				reader.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties file not found at "+propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!=null) return driverPath;
		else throw new RuntimeException("driverPath not specified in config.properties file.");
	}
	
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait!=null)	return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in config.properties file.");
	}
	
	public String getApplicationURL() {
		String url = properties.getProperty("url");
		if(url!=null) return url;
		else throw new RuntimeException("Application URL is not specified in config.properties file.");
	}
	
	public String getFilePath() {
		String filePath = properties.getProperty("filePath");
		if(filePath!=null) return filePath;
		else throw new RuntimeException("File Path is not specified in config.properties file.");
	}
	
}
