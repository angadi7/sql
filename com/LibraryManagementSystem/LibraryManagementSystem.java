package com.LibraryManagementSystem;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780060935467"));
        library.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"));

        // Display all books
        System.out.println("Books in the library:");
        library.displayBooks();

        // Linear Search
        String searchTitle = "1984";
        long startTime = System.nanoTime();
        Book foundBook = library.linearSearch(searchTitle);
        long endTime = System.nanoTime();
        System.out.println("\nLinear Search:");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found");
        }
        System.out.println("Time taken (ns): " + (endTime - startTime));

        // Binary Search
        startTime = System.nanoTime();
        foundBook = library.binarySearch(searchTitle);
        endTime = System.nanoTime();
        System.out.println("\nBinary Search:");
        if (foundBook != null) {
            System.out.println("Found: " + foundBook);
        } else {
            System.out.println("Book not found");
        }
        System.out.println("Time taken (ns): " + (endTime - startTime));
    }
}
