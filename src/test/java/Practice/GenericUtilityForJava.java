package Practice;

import genericUtilities.JavaFileUtility;

public class GenericUtilityForJava {

	public static void main(String[] args) 
	{
		JavaFileUtility Juti = new JavaFileUtility();
		int num = Juti.getrandomnumber();
		System.out.println(num);
		
		String date = Juti.getSystemDate();
		System.out.println(date);
		
		
	}
	
	

}
