package lms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BookManager {
	
private ArrayList<Book> bl;
private HashSet<Book> bs;
	public BookManager()
	{
		bl=new ArrayList<Book>();
		bs=new HashSet<Book>();
	}
	public void addBook()
	{
		Book b=new Book();
		Scanner sc=new Scanner(System.in);
		System.out.println("*****select category:*****");
		System.out.println("1.Computer");
		System.out.println("2.Electronics");
		System.out.println("3.Electrical");
		System.out.println("4.Civil");
		System.out.println("5.Mechanical");
		System.out.println("6.Architecture");
		System.out.println("7.Back to main menu");
		System.out.println("**************************");
		System.out.println("enter your choice:");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:b.setCategory("Computer");
				break;
		case 2:b.setCategory("Electronics");
				break;
		case 3:b.setCategory("Electrical");
				break;
		case 4:b.setCategory("Civil");
				break;
		case 5:b.setCategory("Mechanical");
				break;
		case 6:b.setCategory("Architecture");
				break;
		case 7:return;
		default:System.out.println("invalid choice");
				return;
		}
		
		System.out.println("enter the information below:");
		System.out.println("enter book id:");
		int id=sc.nextInt();
		System.out.println("enter book name:");
		String name=sc.next();
		System.out.println("enter book author:");
		String author=sc.next();
		System.out.println("enter book quantity:");
		int qty=sc.nextInt();
		System.out.println("enter book price:");
		float price=sc.nextFloat();
		
		b.setId(id);
		b.setName(name);
		b.setAuthor(author);
		b.setQty(qty);
		b.setPrice(price);
	
		
		bl.add(b);
		
	}
	public void delete(int id)
	{
		Iterator<Book> itr=bl.iterator();
		while(itr.hasNext())
		{
			
			if(id==itr.next().getId())
			{
				itr.remove();
				System.out.println("deleted successfully");
				return;
			}
		}
		System.out.println("no such book exist");
	}
	public Book search(int id)
	{
		bs.addAll(bl);
		Iterator<Book> itr=bs.iterator();
		Book b=null;
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.getId()==id)
				return b;
		}
			return b;	
	}
	public Book search(String name)
	{
		Book b=null;
		bs.addAll(bl);
		Iterator<Book> itr=bs.iterator();
		
		while(itr.hasNext())
		{
			b=itr.next();
			if(b.getName().equals(name))
				return b;
		}
		return b;
	}
	public void editBook()
	{
		Book b=null;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the id or name of book to edit:");
		String input=sc.next();
		
		try {
		b=search(Integer.parseInt(input));
		}
		catch(NumberFormatException e)
		{
			b=search(input);
		}
		finally
		{
			if(b!=null) {
			System.out.println("enter the field to update it's value:");
			System.out.println("1.quantity\n2.price");
			String label=sc.next();
			
			switch(label)
			{
			case "1":System.out.println("enter the new value:");
				
						b.setQty(sc.nextInt());
						break;
			case "2":System.out.println("enter the new value:");
			
						b.setPrice(sc.nextFloat());
						break;
			
						
			}
			}
			else
				System.out.println("no such book exist");
			
		}
	}
	public void display()
	{
		Iterator<Book> itr=bl.iterator();
		System.out.println("Category\tId\tBookName\tAuthor\tquantity\tprice\tRackNo");
		while(itr.hasNext())
		{
			Book b=itr.next();
			System.out.println(b.getCategory()+"\t"+b.getName()+"\t"+b.getAuthor()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t");
		}
	}
}
