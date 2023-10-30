package Practice;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;

public class GenericUtilityForPropertyFile {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility PFUT = new PropertyFileUtility();
		String value = PFUT.readDataFromPropertyFile("url");
		System.out.println(value);
		
		String value1 = PFUT.readDataFromPropertyFile("browser");
		System.out.println(value1);
		
	}

}
