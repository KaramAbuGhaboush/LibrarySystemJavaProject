/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Library {

    private Collection<Book> books;
    private Collection<Student> students;
    private Collection<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        loans = new ArrayList<>();

    }

    // Methods for book management
    public void addBook(Book book) {
        books.add(book);
    }
    
       public Book searchByNo(int number) {
        for (Book book : books) {
            if (book.getNo() == number) {
                return book;
            }
        }
        return null;
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchByAuthor(String authorName) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // Methods for student management
    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Methods for loan handling
    public boolean loanBook(Student student, Book book) {
        if (student.getNumLoans() < 3 && !book.inLoan()) {
            Loan loan = new Loan(book, student);
            loans.add(loan);
            book.setOnLoan(true);
            student.incrementNumLoans();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loans.remove(loan);
                book.setOnLoan(false);
                loan.getStudent().decrementNumLoans();
                return true;
            }
        }
        return false;
    }

    // Method to check overdue loans
    public List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }

    // Getters for books, students, and loans in the library
    public Collection<Book> getBooks() {
        return books;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public Collection<Loan> getLoans() {
        return loans;
    }


    public Author getAuthorByName(String nameToFind) {
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(nameToFind)) {
                return book.getAuthor(); // Found the author by name, return it
            }
        }
        return null; // Author not found
    }

}
