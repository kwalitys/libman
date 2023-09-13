package com.libman;

import java.io.*;
import java.util.*;

public class Catalogue {
	File file;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw;
	BufferedReader br;
	private Map<String, Book> booklist = new HashMap<String, Book>();
	private Map<String, CD> CDlist = new HashMap<String, CD>();
	private Map<String, DVD> DVDlist = new HashMap<String, DVD>();
	private Map<String, Magazine> magazinelist = new HashMap<String, Magazine>();

	Catalogue() throws IOException {
		file = new File("C:/Learn/Projects/Stock.txt");
		fw = new FileWriter(file, true);
		fr = new FileReader(file);
		bw = new BufferedWriter(fw);
		br = new BufferedReader(fr);
	}
	// HashMap Insertion Block
	void mapping() {
		try {
			String str = "";
			while ((str = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str, "|");
				String code = "";
				String v=st.nextToken();
				if (v.equals("BOOK:")) {
					code = st.nextToken();
					Book book = new Book(code, st.nextToken(), st.nextToken(), st.nextToken(),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken()));
					booklist.put(code, book);
					code = "";
					continue;
				}
				if (v.equals("CD:")) {
					code = st.nextToken();
					CD cd = new CD(code, st.nextToken(), st.nextToken(), st.nextToken(),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken()));
					CDlist.put(code, cd);
					code = "";
					continue;
				}
				if (v.equals("DVD:")) {
					code = st.nextToken();
					DVD dvd = new DVD(code, st.nextToken(), st.nextToken(), st.nextToken(),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken()));
					DVDlist.put(code, dvd);
					code = "";
					continue;
				}
				if (v.equals("MAGAZINE:")) {
					code = st.nextToken();
					Magazine magazine = new Magazine(code, st.nextToken(), st.nextToken(), st.nextToken(),
							Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
							Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken()));
					magazinelist.put(code, magazine);
					code = "";
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Searching block
	void Search(File file, int pos) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter: ");
		String str = "";
		int n = 0;
		Double d = 0.0;
		if (pos <= 4) {
			str = sc.nextLine();
		} else if (pos == 5 || pos == 6) {
			n = sc.nextInt();
		} else {
			d = sc.nextDouble();
		}
		FileReader fr1 = new FileReader(file);
		BufferedReader br1 = new BufferedReader(fr1);
		String line = "";
		if (pos <= 4) {
			while ((line = br1.readLine())!= null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				String w = "";
				String type = "";
				String code = "";
				boolean notFoundFlag = false;
				for (int i = 0; i <= pos; i++) {
					if (i == 0) {
						type = st.nextToken();
					}
					if (i == 1) {
						code = st.nextToken();
						if (pos == 1) {
							w = code;
						}
					}
					if (i!=0 && i!=1 && i!=pos) {
						String c = st.nextToken();
					}
					if (i == pos && i!=1) {
						w = st.nextToken();
					}
					if (w.equals(str)) {
						if (type.equals("BOOK:")) {
							Book book1 = booklist.get(code);
							book1.display();
						} else if (type.equals("CD:")) {
							CD cd1 = CDlist.get(code);
							cd1.display();
						} else if (type.equals("DVD:")) {
							DVD dvd1 = DVDlist.get(code);
							dvd1.display();
						} else if (type.equals("MAGAZINE:")) {
							Magazine magazine1 = magazinelist.get(code);
							magazine1.display();
						} 
					}else {
						notFoundFlag = true;
					}
				}
				
				line = "";
			}	
		}
		if (pos == 5 || pos == 6) {
			while ((line = br1.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				int w = 0;
				String type = "";
				String code = "";
				for (int i = 0; i <= pos; i++) {
					if (i == 0) {
						type = st.nextToken();
					}
					if (i == 1) {
						code = st.nextToken();
					}
					if (i == pos) {
						w = Integer.parseInt(st.nextToken());
					}
					if (w == n) {
						if (type.equals("BOOK:")) {
							Book book1 = booklist.get(code);
							book1.display();
						} else if (type.equals("CD:")) {
							CD cd1 = CDlist.get(code);
							cd1.display();
						} else if (type.equals("DVD:")) {
							DVD dvd1 = DVDlist.get(code);
							dvd1.display();
						} else if (type.equals("Magazine:")) {
							Magazine magazine1 = magazinelist.get(code);
							magazine1.display();
						} else {
							System.out.println("Error identifying item");
						}
					}
				}
				line = "";
			}	
		}
		if (pos == 7) {
			while ((line = br1.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				double w = 0.0;
				String type = "";
				String code = "";
				for (int i = 0; i <= pos; i++) {
					if (i == 0) {
						type = st.nextToken();
					}
					if (i == pos) {
						w = Double.parseDouble(st.nextToken());
					}
					
					if (w == d) {
						if (type.equals("BOOK:")) {
							Book book1 = booklist.get(code);
							book1.display();
						} else if (type.equals("CD:")) {
							CD cd1 = CDlist.get(code);
							cd1.display();
						} else if (type.equals("DVD:")) {
							DVD dvd1 = DVDlist.get(code);
							dvd1.display();
						} else if (type.equals("Magazine:")) {
							Magazine magazine1 = magazinelist.get(code);
							magazine1.display();
						} else {
							System.out.println("Error identifying item");
						}
					}
				}
			}	
		}
		
	}

	// Indexing a new item Block
	void index(Book book) {
		try {
			bw.write("BOOK:|" + book.code + "|" + book.name + "|" + book.author + "|" + book.publisher + "|" + book.year
					+ "|" + book.stock + "|" + book.price + "|" + book.noOfPages + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Some error has occured while indexing book.");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void index(CD cd) {
		try {
			bw.write("CD:|" + cd.code + "|" + cd.name + "|" + cd.author + "|" + cd.publisher + "|" + cd.year + "|"
					+ cd.stock + "|" + cd.price + "|" + cd.duration + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Some error has occured while indexing cd.");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	void index(DVD dvd) {
		try {
			bw.write("DVD:|" + dvd.code + "|" + dvd.name + "|" + dvd.author + "|" + dvd.publisher + "|" + dvd.year + "|"
					+ dvd.stock + "|" + dvd.price + "|" + dvd.duration + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Some error has occured while indexing dvd.");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void index(Magazine magazine) {
		try {
			bw.write("MAGAZINE:|" + magazine.code + "|" + magazine.name + "|" + magazine.author + "|"
					+ magazine.publisher + "|" + magazine.year + "|" + magazine.stock + "|" + magazine.price + "|"
					+ magazine.noOfPages + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Some error has occured while indexing magazine.");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
