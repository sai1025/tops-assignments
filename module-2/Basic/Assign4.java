

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 5 random integers:");
		
		int [] numbers=new int[5];
		
		IntStream.range(0,5).forEach(i->numbers[i]=sc.nextInt());
		System.out.println(Arrays.toString(numbers));
		int sum=0;
		double avg=0;
		for(int i:numbers)
		{
			sum+=i;
		}
		avg=sum/5.0;
		
		System.out.println("sum:"+sum);
		System.out.println("avg:"+avg);

	}

}
