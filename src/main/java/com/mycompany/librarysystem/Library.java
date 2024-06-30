/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarysystem;

/**
 *
 * @author karamyzx
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {

    private static final String BOOKS_FILE = "Library/books.data";
    private static final String STUDENTS_FILE = "Library/students.data";
    private static final String LOANS_FILE = "Library/loans.data";

    private Collection<Book> books;
    private Collection<Student> students;
    private Collection<Loan> loans;

    public Library() {
        books = loadItems(BOOKS_FILE, this::parseBook);
        students = loadItems(STUDENTS_FILE, this::parseStudent);
        loans = loadItems(LOANS_FILE, this::parseLoan);

    }

    private <T> Collection<T> loadItems(String fileName, Function<String, T> parser) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.map(parser).collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Book parseBook(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 9) {
                return null;
            }

            Author author = new Author();
            author.setName(parts[1]);
            author.setAddress(parts[2]);
            author.setBirthDate(dateFormat.parse(parts[3]));

            Date date = dateFormat.parse(parts[6]);

            Book book = new Book(parts[0], author, parts[4], Integer.parseInt(parts[5]), date);
            book.setNo(Integer.parseInt(parts[7]));
            book.setOnLoan(Boolean.parseBoolean(parts[8]));

            return book;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number from the file: " + line + "\nError: " + e.getMessage());
            return null;
        } catch (ParseException e) {
            System.err.println("Error parsing date from the file: " + line + "\nError: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error occurred while parsing the file: " + line + "\nError: " + e.getMessage());
            return null;
        }

    }

    private Student parseStudent(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length != 6) {
                return null;
            }

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String address = parts[2];
            Date birthDate = dateFormat.parse(parts[3]);
            String major = parts[4];
            int numLoans = Integer.parseInt(parts[5]);

            Student student = new Student(id, name, address, birthDate, major);
            student.setNumLoans(numLoans);
            return student;
        } catch (NumberFormatException | ParseException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private Loan parseLoan(String line) {
        String[] parts = line.split(",");
        Book book = searchByNo(Integer.parseInt(parts[0]));
        Student student = findStudentById(Integer.parseInt(parts[1]));
        LocalDate dueDate = LocalDate.parse(parts[2]);
        Loan loan = new Loan(book, student);
        loan.setDueDate(dueDate);
        return loan;
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

    public void addBook(Book book) {
        books.add(book);
        saveItem(BOOKS_FILE, book.toFileString());
    }

    public void addStudent(Student student) {
        students.add(student);
        saveItem(STUDENTS_FILE, student.toFileString());
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean loanBook(Student student, Book book) {
        if (student.getNumLoans() < 3 && !book.inLoan()) {
            Loan loan = new Loan(book, student);
            loans.add(loan);
            saveItem(LOANS_FILE, loan.toFileString());

            book.setOnLoan(true);
            updateBookFile();

            student.incrementNumLoans();
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                loans.remove(loan);
                saveItem(LOANS_FILE, convertLoanListToFileString(loans));

                book.setOnLoan(false);
                updateBookFile();

                loan.getStudent().decrementNumLoans();
                return true;
            }
        }
        return false;
    }

    public List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }

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
                return book.getAuthor();
            }
        }
        return null;
    }

    private void saveItem(String fileName, String itemString) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(itemString);
            writer.newLine();
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBookFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for (Book book : books) {
                writer.write(book.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    private String convertLoanListToFileString(Collection<Loan> loans) {
        return loans.stream()
                .map(Loan::toFileString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String convertBookToFileString(Book book) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.join(",", book.getTitle(), book.getAuthor().getName(), book.getAuthor().getAddress(),
                dateFormat.format(book.getAuthor().getBirthDate()), book.getGenre(), Integer.toString(book.getVersion()),
                dateFormat.format(book.getDate()), Integer.toString(book.getNo()), Boolean.toString(book.inLoan()));
    }

    private String convertStudentToFileString(Student student) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.join(",", Integer.toString(student.getId()), student.getName(), student.getAddress(),
                dateFormat.format(student.getBirthDate()), student.getMajor(), Integer.toString(student.getNumLoans()));
    }

    private String convertLoanToFileString(Loan loan) {
        return String.join(",", Integer.toString(loan.getBook().getNo()), Integer.toString(loan.getStudent().getId()),
                loan.getDueDate().toString());
    }

}
