package com.libman;

public class Book extends Item {
	int noOfPages;
	Book(String code, String name, String author, String publisher, int year, int stock, 
		double price, int noOfPages) {
		super(code, name, author, publisher, year, stock, price);
		this.noOfPages=noOfPages;
	}
	void display() {
		super.display();
		System.out.println("The number of pages: " +noOfPages);
		System.out.println("----------------");
	}

}
