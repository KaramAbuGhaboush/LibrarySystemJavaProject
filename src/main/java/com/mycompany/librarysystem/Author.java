/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.text.SimpleDateFormat;

public class Author {

    private int id;
    private String name;
    private String address;
    private SimpleDateFormat birthDate;
    private static int count;

    public Author(String name, String address, SimpleDateFormat birthDate) {
        this.id = count++;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

    Author() {
    }

    // Getters and Setters for the Author attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SimpleDateFormat getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(SimpleDateFormat birthDate) {
        this.birthDate = birthDate;
    }

    // Method to get information about the author
    public String getInfo() {
        return "Author ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nBirth Date: " + birthDate.toString();
    }
}
