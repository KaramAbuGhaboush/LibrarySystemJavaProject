/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.util.Date;

public class Loan {
    private Book book;
    private Student student;
    private Date dueDate;

    public Loan(Book book, Student student, Date dueDate) {
        this.book = book;
        this.student = student;
        this.dueDate = dueDate;
    }

    // Getters and Setters for the Loan attributes
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    // Method to get information about the loan
    public String getInfo() {
        return "Book: " + book.getTitle() + "\nStudent: " + student.getName() + "\nDue Date: " + dueDate.toString();
    }

    // Method to check if the loan is overdue
    public boolean isOverdue() {
        Date currentDate = new Date();
        return currentDate.after(dueDate);
    }

    // Other methods related to the Loan class
    // For example, any specific loan-related functionalities could be added here.
    // ...
}

