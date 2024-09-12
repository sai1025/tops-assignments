

import java.util.Scanner;

public class Assign7 {

	public static int noOfDigits(long integer)
	{
		int digits=0;
		while(integer>0)
		{
			integer=integer/10;
			digits++;
		}
		return digits;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a positive integer less than 10 billion:");
		long integer=sc.nextLong();
		if(Long.signum(integer)==1) {
		int digits=noOfDigits(integer);
		System.out.println("no of digits in integer "+integer+" are:"+digits);
		}
		else
		System.out.println("enter positive integer");

	}

}
