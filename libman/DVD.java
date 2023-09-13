package com.libman;
import java.util.*;
public class DVD extends Item{
	int duration;
	List<String> cast;
	DVD(String code, String name, String author, String publisher, int year, int stock, 
		double price, int duration) {
		super(code, name, author, publisher, year, stock, price);
		this.duration = duration;
	}
	void display() {
		super.display();
		System.out.println("The duration: " +duration);
		System.out.println("----------------");
		
	}
}
