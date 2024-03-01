package ru.rasul.MyFirstSpringSecurityApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Column(name = "username")
    @Size(min = 2,max = 100, message = "имя должно быть от 2 до 100 символов")
    private String userName;
    @Column(name = "year_of_birrth")
    @Min(value = 1900, message = "год рождения не должен быть меньше чем 1900")
    private int yearOfBirth;
    @Column(name = "password")
    private String password;

    public Person(){}
    public Person(String userName,  String password, int yearOfBirth){
        this.userName=userName;
        this.password=password;
        this.yearOfBirth=yearOfBirth;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
