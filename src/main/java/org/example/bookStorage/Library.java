package org.example.bookStorage;


import org.example.bookStorage.model.Author;
import org.example.bookStorage.model.Book;
import org.example.bookStorage.model.Gender;
import org.example.bookStorage.storage.AuthorStorage;
import org.example.bookStorage.storage.BookStorage;
import org.example.bookStorage.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Library implements LibraryCommands{
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    public static void main(String[] args) {
        Author author1 = new Author("0", "name1", "surname1", "12345678", new Date(), Gender.FEMALE);
        bookStorage.add(new Book("01", "book 1", author1 , 100, 1, new Date()));
        authorStorage.add(author1);
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
                    authorStorage.print();
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
        authorStorage.print();
        System.out.println("Please choose author ID");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if (author != null) {
            System.out.println("Please input book id");
            String id = scanner.nextLine();

            System.out.println("Please input book title");
            String title = scanner.nextLine();

            System.out.println("Please input price");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Please input quantity");
            int qty = Integer.parseInt(scanner.nextLine());
            Book book = new Book(id, title, author, price, qty, new Date());
            Book bookById = bookStorage.getBookById(id);
            if (bookById == null) {
                bookStorage.add(book);
                System.out.println("Added!");
            }
            else{
                System.out.println("Book with " + id + " already exists!");
            }
        }
        else{
            System.out.println("Author with entered id does not exist");
        }
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
        System.out.println("Please input id, name");
        String authorDataStr = scanner.nextLine();
        String[] authorDataArr = authorDataStr.split(",");
        if (authorDataArr.length == 6) {
            String id = authorDataArr[0];

            if (authorStorage.getAuthorById(id) == null) {
                Author author = new Author();
                author.setId(id);
                author.setName(authorDataArr[1]);
                author.setSurname(authorDataArr[2]);
                author.setPhone(authorDataArr[3]);
                Date dateOfBirth = DateUtil.fromStringToDate(authorDataArr[4]);
                author.setDateOfBirth(dateOfBirth);
                author.setGender(Gender.valueOf(authorDataArr[5]));
                authorStorage.add(author);
                System.out.println("Author added!");
            }
            else{
                System.out.println("Author with id " + id + " already exists");
            }
        }
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
        authorStorage.print();
        System.out.println("Please choose author ID");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if(author != null){
            bookStorage.searchByAuthor(author);
        }
    }

}
