/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.time.LocalDate;

public class Loan {

    private Book book;
    private Student student;
    private LocalDate dueDate;

    public Loan(Book book, Student student) {
        this.book = book;
        this.student = student;
        this.dueDate = LocalDate.now().plusDays(5);
    }

    Loan() {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate currentDate) {
        this.dueDate = currentDate;
    }

    // Method to get information about the loan
    public String getInfo() {
        return "Book: " + book.getTitle() + "\nStudent: " + student.getName() + "\nDue Date: " + dueDate.toString();
    }

    // Method to check if the loan is overdue
    public boolean isOverdue() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(dueDate);
    }
    
     public String toFileString() {
        return getBook().getNo() + "," + getStudent().getId() + "," + getDueDate();
    }

}
