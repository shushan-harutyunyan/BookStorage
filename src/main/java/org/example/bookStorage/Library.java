package org.example.bookStorage;


import org.example.bookStorage.model.Author;
import org.example.bookStorage.model.Book;
import org.example.bookStorage.model.Gender;
import org.example.bookStorage.service.AuthorService;
import org.example.bookStorage.service.BookService;
import org.example.bookStorage.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Library implements LibraryCommands{
    private static Scanner scanner = new Scanner(System.in);
    private static BookService bookStorage = new BookService();
    private static AuthorService authorStorage = new AuthorService();
    public static void main(String[] args) {
        boolean running = true;
        while (running){
            LibraryCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    running = false;
                    break;

                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_AUTHOR:
                    try {
                        addAuthor();
                    }
                    catch (ParseException e){
                        System.out.println(e);
                    }
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_ALL_AUTHORS:
                    break;
                case SEARCH_BOOK_BY_NAME:
                    searchBookByName();
                    break;
                case UPDATE_BOOK:
                    updateBook();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case SEARCH_BOOK_BY_PRICE:
                    searchBookByPrice();
                    break;
                case SEARCH_BOOK_BY_AUTHOR:
                    searchBookByAuthor();
                    break;
                default:
                    System.out.println("Wrong command");
            }

        }
    }

    private static void addBook() {

    }

    private static void deleteBook(){
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById == null) {
            System.out.println("Book does not exist");
        }
        bookStorage.deleteBook(bookId);
    }

    private static void updateBook(){
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById != null){
            System.out.println("Please input book's new title");
            String title = scanner.nextLine();
            System.out.println("Please input book's new author");
            String authorName = scanner.nextLine();
            System.out.println("Please input book's new quantity");
            String qtyStr = scanner.nextLine();
            System.out.println("Please input book's new price");
            String priceStr = scanner.nextLine();
            if (title != null && !title.isEmpty()){
                bookById.setTitle(title);
            }
            if (authorName != null && !authorName.isEmpty()){
                Author author = authorStorage.getAuthorByName(authorName);
                if (author != null && !authorName.isEmpty())
                    bookById.setAuthor(author);
            }
            else{
                System.out.println("Please input a valid author name");
            }
            if (qtyStr != null && !qtyStr.isEmpty()){
                bookById.setQty(Integer.parseInt(qtyStr));
            }

            if (priceStr != null && !priceStr.isEmpty()){
                bookById.setPrice(Integer.parseInt(priceStr));
            }
        }
    }
    private static void addAuthor() throws ParseException {

    }
    private static void searchBookByName(){
        System.out.println("Please input book name");
        String input = scanner.nextLine();
        bookStorage.searchByName(input);
    }
    private static void searchBookByPrice(){
        System.out.println("Please input min-max prices");
        String priceStr = scanner.nextLine();
        String[] pricesArray = priceStr.split("-");
        if (pricesArray.length == 2){
            try {
                double min = Double.parseDouble(pricesArray[0]);
                double max = Double.parseDouble(pricesArray[1]);
                bookStorage.searchByPrice(min, max);
            }
            catch (NumberFormatException e){
                System.out.println("Please input only digits");
            }
        }
    }
    private static void searchBookByAuthor(){

    }

}
