package cn.itcast.property;


public class Book {

	
	private String bookname;
	
	public Book(String name){
		this.bookname=name;
		
	}
	
	public void testBook(){
		System.out.println("book....."+bookname);
	}
}
