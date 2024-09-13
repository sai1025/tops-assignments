package basic;

import java.util.stream.IntStream;

public class Assign8 {

	public static void printNumbersDivisibleBy3_5()
	{
		IntStream.range(1, 100).filter(n->n%3==0||n%5==0).forEach(n->System.out.print(n+" "));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("numbers divisible by 3 or 5:");
		printNumbersDivisibleBy3_5();
	}

}
