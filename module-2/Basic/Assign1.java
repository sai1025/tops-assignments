import java.util.Scanner;
class GreatestOfThree
{
	public static void maxOfThree(int a,int b,int c)
	{
		
		System.out.println("greatest number among "+a+","+b+","+c+" is:"+(a>b?(a>c?a:c):(b>c?b:c)));
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter three number:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();

		maxOfThree(a,b,c);
	}
}