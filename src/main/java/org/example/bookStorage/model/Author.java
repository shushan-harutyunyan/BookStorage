package org.example.bookStorage.model;

import org.example.bookStorage.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Author {

    String id;
    private String name;
    private String surname;
    private String phone;
    private Date dateOfBirth;
    private Gender gender;

    public Author(String id, String name, String surname, String phone, Date dateOfBirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    public Author(){

    };
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + DateUtil.fromDateToString(dateOfBirth) +
                '}';
    }
}