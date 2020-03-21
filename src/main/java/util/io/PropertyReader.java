package util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import util.driver.DriverFactory;

public class PropertyReader extends DriverFactory{
	public Properties prop;
	public File propertyFile;
	public FileInputStream fileInput = null;
	public PropertyReader() {
		super();
		loadProperty();
	}
	
	public void loadProperty() {
		propertyFile = new File("C:\\Users\\Alex\\Automation\\autoFrame\\src\\main\\java\\properties\\element.properties");
		try {
			fileInput = new FileInputStream(propertyFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		prop = new Properties();
		// attempt to read the property file. 
		try {
			prop.load(fileInput);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String getProperty(String key) {
		return prop.getProperty(key);		
	}
}
