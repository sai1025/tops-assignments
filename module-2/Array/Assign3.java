package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.System;
public class Assign3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size1,size2;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of first array:");
		size1=sc.nextInt();
		
		System.out.println("enter the size of second array:");
		size2=sc.nextInt();
		
		int arr[]=new int[size1];
		int arr1[]=new int[size2];
		
		System.out.println("enter the elements of array:");
		arr=Arrays.stream(arr).map(n->sc.nextInt()).toArray();
		
		
		new String().length();
		System.out.println("enter the elements of array:");
		arr1=Arrays.stream(arr1).map(n->sc.nextInt()).toArray();
		
		
		System.out.println("enter A/D for sorting array1 in ascending or descending order:");
		String order=sc.next();
		if(order.equals("A"))
			Arrays.sort(arr);
		else
			arr=Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
;		
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("enter A/D for sorting array2 in ascending or descending order:");
		order=sc.next();
		if(order.equals("A"))
			Arrays.sort(arr1);
		else
			arr1=Arrays.stream(arr1).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
;		
		System.out.println(Arrays.toString(arr1));
		
		

	}

}
