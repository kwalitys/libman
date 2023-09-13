package com.libman;

public class CD extends Item{
	int duration;
	CD(String code, String name, String author, String publisher, int year, int stock, 
		double price, int duration) {
		super(code, name, author, publisher, year, stock, price);
		this.duration = duration;
	}
	void display() {
		super.display();
		System.out.println("The duration: " +duration+" minutes");
		System.out.println("----------------");
	}
}
