import java.util.Scanner;
public class Assign3
{
	public static boolean isLeap(int year)
	{
		if((year%100==0 && year%400==0) || year%4==0)
		return true;
		else
		return false;
		
	}
	public static void printN(int n)
	{
		while(n>0)
		{
			n--;
			System.out.print((10-n)+" ");
		}
			
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the year:");
		int year=sc.nextInt();
		
		boolean leap=isLeap(year);
		
		System.out.println(year+" is a leap year:"+leap);
		
		System.out.println("printing first 10 natural numbers using while loop:");
		printN(10);
	}
	
}