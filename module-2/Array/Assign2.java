package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Assign2 {

	public static int secondMaxOfArray(int[] arr)
	{
		return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).skip(1).max().getAsInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {3,2,44,55,-1};
		
		
		System.out.println("2nd max number from given array "+Arrays.toString(arr)+" is:"+secondMaxOfArray(arr));
		

	}

}
