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
						break;
				case 3:	String search="Y";
						Book b=null;
						do {
							System.out.println("1.search by Id");
							System.out.println("2.search by Name");
							System.out.println("enter your choice");
							int ch=sc.nextInt();
							
							if(ch==1)
							{
								System.out.println("****search books by Id****");
								System.out.println("enter the book id");
								b=bm.search(sc.nextInt());
							}else if(ch==2)
							{
								System.out.println("****search books by Name*****");
								System.out.println("enter the book name");
								b=bm.search(sc.next());
								//System.out.println(b);
							}
							
							if(b!=null)
							{
								System.out.println("the book is available");
								System.out.println("Id:"+b.getId());
								System.out.println("Name:"+b.getName());
								System.out.println("Author:"+b.getAuthor());
								System.out.println("Quantity:"+b.getQty());
								System.out.println("Price:"+b.getPrice());
							}
							else
								System.out.println("no such book exist");
							
							
							System.out.println("try another search(y/n)_");
							search=sc.next();
						}while(search.equalsIgnoreCase("y"));
						break;
						
				case 4:bm.display();
						break;
				case 5:bm.editBook();
						break;
				case 6:	System.out.println("enter old password:");
						String old=sc.next();
						System.out.println("enter new password:");
						String newp=sc.next();
						if(old.equals(password)) {
							password=newp;
						System.out.println("password changed successfully");	
						}
						else
							System.out.println("enter correct password");
						
						System.out.println("press anykey to continue");
						sc.next();
						break;
				case 7:System.out.println("exiting in 3 seconds.....>");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0);
						
				
					
					
				}
			}while(choice!=7);
			
			
			
		}
		else
			System.out.println("access denied:");
		
		
	}

}
