package com.valcon.com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Library {
	private List<Book> books;

	public Library() {
		this.books = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void issueBook(Book book, Member member) {
		if (book.isAvailable()) {
			book.setIssued(true);
			book.setIssuedTo(member);
			book.setIssuedDate(LocalDate.now());
			System.out.println("Book " + book.getTitle() + " issued to member " + member.getName());
		} else {
			System.out.println("Book " + book.getTitle() + " is not available");
		}
	}

	public void returnBook(Book book) {
		if (book.isIssued()) {
			Member member = book.getIssuedTo();
			book.setIssued(false);
			book.setIssuedTo(null);
			book.setIssuedDate(null);
			System.out.println("Book " + book.getTitle() + " returned by member " + member.getName());
		} else {
			System.out.println("Book " + book.getTitle() + " is not issued");
		}
	}
}

class Book {
	private String title;
	private boolean available;
	private boolean issued;
	private Member issuedTo;
	private LocalDate issuedDate;

	public Book(String title) {
		this.title = title;
		this.available = true;
		this.issued = false;
		this.issuedTo = null;
		this.issuedDate = null;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isIssued() {
		return issued;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public Member getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(Member issuedTo) {
		this.issuedTo = issuedTo;
	}

	public LocalDate getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
}

class Member {
	private String name;

	public Member(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class LibrarySystemDemo {
	public static void main(String[] args) {
		Library library = new Library();

		Book book1 = new Book("Introduction to Java Programming");
		Book book2 = new Book("Clean Code");
		Book book3 = new Book("The Alchemist");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);

		Member member1 = new Member("John");
		Member member2 = new Member("Alice");

		library.issueBook(book1, member1);
		library.issueBook(book2, member2);

		library.returnBook(book1);
		library.returnBook(book3);
	}
}
