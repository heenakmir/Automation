package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class ReadAndWriteDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//********READ THE DATA FROM PROPERTY FILE*******//
		/*//step1:open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
// step2:create object of properties for java.util package
		Properties pro = new Properties();
		//step3:load the file input stream into properties
		 pro.load(fis);
		 //step4:provide key and read the value
		 String value = pro.getProperty("browser");
		 System.out.println(value);*/
		
	//************WRITE THE DATA INTO PROPERTY FILE********//
		FileOutputStream file = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
	    prop.put("browser", "firefox");
	    prop.put("url", "http://localhost:8888");
	    prop.put("username", "admin");
	    prop.put("password", "admin");
	    prop.store(file, "this is my prop file1");
	 
	}

}
