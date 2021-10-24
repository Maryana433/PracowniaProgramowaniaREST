package org.test.Entity;

import javax.persistence.*;
import java.util.Date;


/*
CREATE DATABASE  PP;
USE PP;



CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(30),
  surname varchar(30),
  data_of_birth Date,
  login varchar(30),
  is_deleted boolean,
  PRIMARY KEY (id)
);
 */
@Entity
@Table(name="users")
public class User {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_of_birth")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public User(){

    }

    public User(int id, Date date, String name, String surname, String login, boolean isDeleted) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
