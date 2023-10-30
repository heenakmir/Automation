package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic method related to java 
 * @author Heena
 *
 */
public class JavaFileUtility 
/**
 * This method will generate random number for every run and return to the caller
 */
{
	public int getrandomnumber()
	{
		Random R = new Random();
		int number = R.nextInt(10000);//this is range from where we want numbers that is 0 to 10000 now
		return number;
	}
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	public String getSystemDate()
	{
	Date d = new Date();	
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	String date = format.format(d);
	return date;
	}
	
		
		
	}


