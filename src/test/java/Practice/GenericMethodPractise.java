package Practice;

public class GenericMethodPractise {

	public static void main(String[] args)//caller
	{
           int sum = add(20,30);
           System.out.println(sum);	
	}
	public static int add(int a,int b)//called
	{
		
		int c=a+b;
	return c;
	}
}
