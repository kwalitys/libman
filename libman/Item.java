package com.libman;

public class Item {
	String name;
	String publisher;
	String author;
	int year;
	int stock;
	double price;
	String code;
	Item(String code, String name, String author, String publisher, int year, int stock, double price) {
		this.code = code;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.stock = stock;
		this.price = price;	
	}
    void display(){
    	System.out.println("Code: "+code);
    	System.out.println("Name: "+name);
    	System.out.println("Author: "+author);
    	System.out.println("Publisher: "+publisher);
    	System.out.println("Year of publishing: "+year);
    	System.out.println("Stock in the catalogue: "+stock);
    	System.out.println("Price: "+price);
    }
	public static void main(String[] args) {

	}

}
