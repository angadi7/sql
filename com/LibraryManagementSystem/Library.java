package com.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library and keep the list sorted
    public void addBook(Book book) {
        books.add(book);
        Collections.sort(books);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Linear Search to find a book by title
    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search to find a book by title
    public Book binarySearch(String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
