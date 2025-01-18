package org.example.bookStorage.model;
import org.example.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private Author author;
    private double price;
    private int qty;
    private Date createdAt;


    public Book(String id, String title, Author author, double price, int qty, Date createdAt){
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
            this.qty = qty;
            this.createdAt = createdAt;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && qty == book.qty && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price, qty);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", qty=" + qty +
                ", createdAt=" + DateUtil.fromDateToString(createdAt) +
                '}';
    }

}
