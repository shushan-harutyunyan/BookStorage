package org.example;

import org.example.bookStorage.db.DBConnectionProvider;
import org.example.bookStorage.model.Author;
import org.example.bookStorage.service.AuthorService;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;

public class Main {
    private static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        DBConnectionProvider dbConnection = DBConnectionProvider.getInstance();
        Author newAuthor = new Author("name", "surname", 13, "email");
        authorService.add(newAuthor);
        List<Author> allAuthors = authorService.getAllAuthors();
        for (Author allAuthor:allAuthors) {
            System.out.println(allAuthor);
        }
    }
}