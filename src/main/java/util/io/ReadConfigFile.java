package util.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import util.config.Constant;

public class ReadConfigFile {
	protected InputStream input = null;
	protected Properties properties = null;
	
	public ReadConfigFile() {
		try {
			input = ReadConfigFile.class.getClassLoader().getResourceAsStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
			properties = new Properties();
			properties.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}	
	public String getBrowser() {
		if(properties.getProperty("browser") == null) {
			return "";
		}
		return properties.getProperty("browser");
	}
}
