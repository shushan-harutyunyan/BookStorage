package org.example.bookStorage.storage;

import org.example.bookStorage.model.Author;
import org.example.bookStorage.model.Book;

public class BookStorage {
    private Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        if (books.length == size) {
            extendStorage();
        }
        books[size++] = book;
    }
    public void deleteBook (String bookId){
        int id = getBookIndexById(bookId);
        for (int i = id + 1; i < size; i++) {
            books[i] = books[i+1];
        }
        size--;
    }
    private void extendStorage() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
    public Book getBookById(String bookId){
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == bookId){
                return books[i];
            }
        }
        return null;
    }
    private int getBookIndexById(String bookId){
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == bookId){
                return i;
            }
        }
        System.out.println("No such book ID");
        return -1;
    }

    public void searchByName(String input){
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (book.getTitle().equals(input)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("There is no such book");
    }
    public void searchByPrice(double min, double max){
        min = Math.min(min, max);
        max = Math.max(min, max);
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (book.getPrice() >= min && book.getPrice() <= max){
                System.out.println(book);
            }
        }
    }

    public void searchByAuthor(Author a){
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (books[i].getAuthor().equals(a)){
                System.out.println(books[i]);
            }
        }
    }
}
