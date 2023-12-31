/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author karamyzx
 */
public class Book implements Display {

    private String title;
    private Author author;
    private int no;
    private String genre;
    private int version;
    private Date date;
    private boolean onLoan;
    private static int count = 0;

    public Book() {
        
    }
    
    public Book(String title, Author author, String genre, int version, Date date) {
        this.title = title;
        this.author = author;
        this.no = count++;
        this.genre = genre;
        this.version = version;
        this.date = date;
        this.onLoan = false; // Initially not on loan
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    @Override
    public String getInfo() {
        return "Title: " + title + "\nAuthor: " + author.getName() + "\nNo: " + no + "\nGenre: " + genre
                + "\nVersion: " + version + "\nDate: " + date.toString();
    }

    @Override
    public boolean inLoan() {
        return onLoan;
    }
    
    public String toFileString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return getTitle() + "," + getAuthor().getName() + "," + getAuthor().getAddress() +
               "," + dateFormat.format(getAuthor().getBirthDate()) + "," + getGenre() +
               "," + getVersion() + "," + dateFormat.format(getDate()) +
               "," + getNo() + "," + inLoan();
    }

}
