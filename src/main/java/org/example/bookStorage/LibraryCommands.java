package org.example.bookStorage;

public interface LibraryCommands {

    String EXIT = "0";
    String ADD_BOOK = "1";
    String ADD_AUTHOR = "2";
    String PRINT_ALL_BOOKS = "3";
    String PRINT_ALL_AUTHORS = "4";
    String SEARCH_BOOK_BY_NAME = "5";
    String UPDATE_BOOK = "6";
    String DELETE_BOOK = "7";
    String SEARCH_BOOK_BY_PRICE = "8";
    String SEARCH_BOOK_BY_AUTHOR = "9";

    static void printCommands(){
        System.out.println("Please Input " + EXIT + " to exit");
        System.out.println("Please Input " + ADD_BOOK + " to add a book");
        System.out.println("Please Input " + ADD_AUTHOR + " to add an author");
        System.out.println("Please Input " + PRINT_ALL_BOOKS + " to print all books");
        System.out.println("Please Input " + PRINT_ALL_AUTHORS + " to print all authors");
        System.out.println("Please Input " + SEARCH_BOOK_BY_NAME + " to search a book by name");
        System.out.println("Please Input " + UPDATE_BOOK + " to update a book");
        System.out.println("Please Input " + DELETE_BOOK + " to delete a book");
        System.out.println("Please Input " + SEARCH_BOOK_BY_PRICE + " to search a book by price");
        System.out.println("Please Input " + SEARCH_BOOK_BY_AUTHOR + " to search a book by author");

    }
}
