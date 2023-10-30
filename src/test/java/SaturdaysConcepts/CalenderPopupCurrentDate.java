package SaturdaysConcepts;

import java.util.Date;

public class CalenderPopupCurrentDate {

	public static void main(String[] args) 
	{
	Date d = new Date();	
String[] Darray = d.toString().split(" ");
String CurrentDate = Darray[0]+" "+Darray[1]+" "+Darray[2]+" "+Darray[5];
System.out.println(CurrentDate);
	}

}
