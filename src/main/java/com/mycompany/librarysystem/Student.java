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

public class Student {

    private int id;
    private String name;
    private String address;
    private Date birthDate;
    private String major;
    private int numLoans;

    public Student() {
        
    }
    public Student(int id, String name, String address, Date birthDate, String major) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.major = major;
        this.numLoans = 0; // Initially doesn't loan any book
    }

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setNumLoans(int numLoans) {
        this.numLoans = numLoans;
    }

    public String getInfo() {
        return "Student ID: " + id + "\nName: " + name + "\nAddress: " + address
                + "\nBirth Date: " + birthDate.toString() + "\nMajor: " + major;
    }

    //Method to get the number of the loaned books.
    public int getNumLoans() {
        return numLoans;
    }

    //Method to add 1 to the numLoans
    public void incrementNumLoans() {
        if (numLoans < 3) {
            numLoans++;
        }
    }

    public void decrementNumLoans() {
        if (numLoans > 0) {
            numLoans--;
        }
    }
    
    public String toFileString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return getId() + "," + getName() + "," + getAddress() +
               "," + dateFormat.format(getBirthDate()) + "," + getMajor() +
               "," + getNumLoans();
    }
}
