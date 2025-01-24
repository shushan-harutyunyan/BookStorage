package org.example.bookStorage.model;

import lombok.*;
import org.example.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Author {

    int id;
    private String name;
    private String surname;
    private String phone;
    private Date dateOfBirth;
    private Gender gender;
    private int age;
    private String email;

    public Author(String name, String surname, int age, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
    public Author(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }
    public void print(){
        System.out.println(this);
    }
}