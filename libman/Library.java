package com.libman;

import java.io.IOException;
import java.util.*;

public class Library {
	static String code;
	static String name;
	static String author;
	static String publisher;
	static int year;
	static int stock;
	static double price;	
	public static int choice() {
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the required number: ");
		System.out.println("Press 1: For Book");
		System.out.println("Press 2: For CD");
		System.out.println("Press 3: For DVD");
		System.out.println("Press 4: For Magazine");
		int choice = sc1.nextInt();
		return(choice);
	}
	public static int choiceSearch() {
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter the required number: ");
		System.out.println("Press 1: To check by code");
		System.out.println("Press 2: To check by name");
		System.out.println("Press 3: To check by author");
		System.out.println("Press 4: To check by publisher");
		System.out.println("Press 5: To check by year");
		System.out.println("Press 6: To check by stock");
		System.out.println("Press 7: To check by price");		
		int choicesearch = sc3.nextInt();
		return(choicesearch);
	}
	public static void itemVal() {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter the code.");
		code = sc2.nextLine();
		System.out.println("Enter the name.");
		name = sc2.nextLine();
		System.out.println("Enter the author.");
		author = sc2.nextLine();
		System.out.println("Enter the publisher.");
		publisher = sc2.nextLine();
		System.out.println("Enter the year.");
		year = sc2.nextInt();
		System.out.println("Enter the stock.");
		stock = sc2.nextInt();
		System.out.println("Enter the price.");
		price = sc2.nextDouble();
	}
	public static void main(String[] args) throws IOException {
		System.out.println("Enter the required number for the following functions:");
		System.out.println("Press 1: To search for scanned item in catalogue.");
		System.out.println("Press 2: To index a new item in the catalogue.");
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		switch (c) {
		case 1:
			int v1 = choiceSearch();
			Catalogue obj1 = new Catalogue();
			obj1.mapping();
			if(v1 <= 4) {
				obj1.Search(obj1.file, v1);
			}else if(v1 == 5 || v1 == 6) {
				obj1.Search(obj1.file, v1);
			}else if(v1 == 7) {
				obj1.Search(obj1.file, v1);
			}
			break;
		case 2:
			int v = choice();
			if(v == 1) {
				itemVal();
				System.out.println("Enter the number of pages.");
				int noOfPages = sc.nextInt();
				Book book = new Book(code, name, author, publisher, year, stock, price, noOfPages);
				Catalogue obj = new Catalogue();
				obj.index(book);
			}else if(v == 2){
				itemVal();
				System.out.println("Enter the duration.");
				int duration = sc.nextInt();
				CD cd = new CD(code, name, author, publisher, year, stock, price, duration);
				Catalogue obj = new Catalogue();
				obj.index(cd);
			}else if(v == 3){
				itemVal();
				System.out.println("Enter the duration.");
				int duration = sc.nextInt();
				DVD dvd = new DVD(code, name, author, publisher, year, stock, price, duration);
				Catalogue obj = new Catalogue();
				obj.index(dvd);
			}else if(v == 4){
				itemVal();
				System.out.println("Enter the no of pages.");
				int noOfPages = sc.nextInt();
				Magazine magazine = new Magazine(code, name, author, publisher, year, stock, price, noOfPages);
				Catalogue obj = new Catalogue();
				obj.index(magazine);
			}else {
				System.out.println("Wrong Input.");
			}
			break;
		}

	}

}
