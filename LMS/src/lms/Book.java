package lms;

public class Book {
	public Book(int id, String name, String author, int qty, float price,String category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.qty = qty;
		this.price = price;
		this.category=category;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	private String category;
	private int id;
	private String name;
	private String author;
	private int qty;
	private float price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", qty=" + qty + ", price=" + price + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
