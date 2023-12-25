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
import java.util.Date;

public class Author {

    private int id;
    private String name;
    private String address;
    private Date birthDate;
    private static int count;

    public Author(String name, String address, Date birthDate) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Method to get information about the author
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Author{" + "id=" + id + ", name='" + name + '\'' +
               ", address='" + address + '\'' + ", birthDate=" + 
               dateFormat.format(birthDate) + '}';
}
}
