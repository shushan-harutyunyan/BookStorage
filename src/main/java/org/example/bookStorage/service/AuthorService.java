package org.example.bookStorage.service;

import org.example.bookStorage.db.DBConnectionProvider;
import org.example.bookStorage.model.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AuthorService {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    public void add(Author author) {
        try {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO author(name, surname, age, email) VALUES('" + author.getName() + "','" + author.getSurname() + "'," + author.getAge() + ",'" + author.getEmail() + "')";
            String sql = String.format(query, author.getName(), author.getSurname(), author.getAge(), author.getEmail());
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                int id = generatedKeys.getInt(1);
                author.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Author> getAllAuthors(){
        String sql = "SELECT * FROM author";
        Statement statement = null;
        List<Author> result = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                Author author = new Author(id, name, surname, age, email);
                result.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Author getAuthorById(int id){
        String sql = "SELECT * FROM author WHERE ID = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                Author author = new Author(name, surname, age, email);
                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Author getAuthorByName(String authorName){

        return null;
    }
    public void deleteAuthorById(int id) {
        if (getAuthorById(id) == null) {
            System.out.println("does not exist");
            return;
        }
        String sql = "DELETE FROM author WHERE id = " + id;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("removed");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void updateAuthor (Author author){
        if (getAuthorById(author.getId()) == null){
            System.out.println("Author with " + author.getId() + " does not exist");
            return;
        }
        String query = "UPDATE author SET name = '%s', surname = '%s', email = '%s', age = '%d' WHERE id='%d'";
        String sql = String.format(query, author.getName(), author.getSurname(), author.getEmail(), author.getAge(), author.getId());
        System.out.println(sql);
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("updated");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
