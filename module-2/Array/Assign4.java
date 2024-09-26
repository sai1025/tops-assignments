package array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assign4 {

	public static void scanMatrix(int a,int b,int[][]arr)
	{
			
		Scanner sc=new Scanner(System.in);
		
		
		IntStream.range(0, a).forEach(i->{
		System.out.println("enter elements of row:"+(i+1));
		IntStream.range(0, b).forEach(j->arr[i][j]=sc.nextInt());
		});
		
	}
	public static void printMatrix(int[][]arr)
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of first matrix:");
		String size1=sc.next();
		System.out.println("enter the size of second matrix:");
		String size2=sc.next();
		
		int a,b;
	
		a=Integer.parseInt(size1.split("*")[0]);
		b=Integer.parseInt(size1.split("*")[1]);
		int arr1[][]=new int[a][b];
		
		scanMatrix(a, b, arr1);
		
	
		a=Integer.parseInt(size2.split("*")[0]);
		b=Integer.parseInt(size2.split("*")[1]);
		int arr2[][]=new int[a][b];
		
		scanMatrix(a, b, arr2);
		
		
		
	}

}
