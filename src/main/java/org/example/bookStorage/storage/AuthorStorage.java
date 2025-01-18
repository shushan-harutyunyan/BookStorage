package org.example.bookStorage.storage;

import org.example.bookStorage.model.Author;

public class AuthorStorage {
    private Author[] authors = new Author[10];
    private int size;

    private void extendStorage() {
        Author[] tmp = new Author[size + 10];
        System.arraycopy(authors, 0, tmp, 0, size);
        authors = tmp;
    }
    public void add(Author author) {
        if (authors.length == size) {
            extendStorage();
        }
        authors[size++] = author;
    }
    public Author getAuthorById(String authorId){
        for (int i = 0; i < size; i++) {
            String current = authors[i].getId();
            if (current.equals(authorId)){
                return authors[i];
            }
        }
        return null;
    }

    public Author getAuthorByName(String authorName){
        for (int i = 0; i < size; i++) {
            if(authors[i].getName().equals(authorName)){
                return authors[i];
            }
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(authors[i]);
        }
    }
}
