package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method to read data from property file
 * @author Heena
 *
 */

public class PropertyFileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}

	 

}
