

import java.util.Scanner;
import java.util.regex.Pattern;

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter character:");
		Scanner sc=new Scanner(System.in);
		String letter=sc.next();
		if(Pattern.matches("^[a-zA-Z]+$",letter)&& !(letter.length()>1))
		{
			if(Pattern.matches("[aeiou]", letter))
				System.out.println("vowel");
			else
				System.out.println("consonant");
		}
		else
		System.out.println("enter character only[a-zA-Z]");
	}

}
