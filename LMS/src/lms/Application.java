package lms;

import java.util.Scanner;

public class Application {

	private static String password="sai@1025";
	private static boolean start(String code)
	{
		if(code.equals(password))
			return true;
		return false;
	}
	private static void menu()
	{
		System.out.println("******Main Menu*******");
		System.out.println("1.Add Book");
		System.out.println("2.delete Book");
		System.out.println("3.search Book");
		System.out.println("4.view Book list");
		System.out.println("5.edit Book record");
		System.out.println("6.change password");
		System.out.println("7.close application");
		
		System.out.println("***********************");
		System.out.println("enter your choice:");
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter password:");
		String code=sc.next();
		if(start(code))
		{
			BookManager bm=new BookManager();
			int choice;
			do {
				menu();
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:bm.addBook();
					break;
			case 2:System.out.println("enter id of book:");
				bm.delete(sc.nextInt());
			}
			}while(choice!=7);
			
			
			
		}
		else
			System.out.println("access denied:");
		
		
	}

}
