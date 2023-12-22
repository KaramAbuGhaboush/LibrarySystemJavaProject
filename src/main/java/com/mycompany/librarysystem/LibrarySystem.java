/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.librarysystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author karamyzx
 */
public class LibrarySystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scan = new Scanner(System.in);

        int choice;
        do {
            System.out.println("""
        Library Management System Menu:
        1. Add Student.
        2. Add Book.
        3. Loan Book.
        4. Return Book.
        5. Search Book by Title.
        6. Search Book by Author.
        7. Search Book by No.
        8. Loaned books list.
        9. Search if a book is loaned.
        10. Exit the App.
        Enter your choice: 
        """);

            choice = scan.nextInt();
            scan.nextLine(); // Consume the newline character.

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the student id: ");
                    int id = scan.nextInt(); //The student id input.
                    scan.nextLine(); // Consume the newline character left in the input buffer after reading the integer.

                    System.out.println("Enter the student name: ");
                    String name = scan.nextLine(); //The student name input.

                    System.out.println("Enter the student address: ");
                    String address = scan.nextLine(); //The student address input.

                    // The student birthDate input
                    SimpleDateFormat birthDate = new SimpleDateFormat("dd/MM/yyyy");
                    boolean validInput = false; // When the date is entered correctly, the value of this variable becomes true.
                    while (!validInput) {
                        System.out.println("Enter the student birth date (in format dd/MM/yyyy): ");
                        String userInput = scan.nextLine();
                        Date parsedDate;
                        try {
                            parsedDate = birthDate.parse(userInput); //parsing the String to a Date Format.
                            System.out.println("Parsed Date: " + parsedDate);
                            validInput = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");

                        }
                    }

                    // The student Major input
                    System.out.println("Enter the student major: ");
                    String major = scan.nextLine();

                    // Confirm adding the student
                    System.out.println("Are you shure to add the student " + name
                            + "\n" + "With ID : " + id
                            + "\n" + "address: " + address
                            + "\n" + "birth date: " + birthDate
                            + "\n" + "major: " + major
                            + "\n" + "press (y) or (Y) for yes, or any another key to cancel.");

                    String inputKey = scan.nextLine(); //The student addition confirmation Key.

                    //Print the confirmation result
                    if (inputKey.equalsIgnoreCase("Y")) {
                        System.out.println("The student " + name + " is added to the system :). ");
                        Student student = new Student(id, name, address, birthDate, major); //Create a new Student object.
                        library.addStudent(student); //Add the new student to the ArrayList students.
                        break;
                    } else {
                        System.out.println("The add request is canceled");
                        break;
                    }

                }
                //--------------------------------------------------------------------------------------------------------------
                //Book Addition

                case 2 -> {
                    System.out.println("Enter the Book Title: ");
                    String title = scan.nextLine(); //The Book title input.

                    System.out.println("Enter the Book Genre: ");
                    String genre = scan.nextLine(); //The Book genre input.

                    System.out.println("Enter the Book Version (as a number): ");
                    int version = scan.nextInt(); //The Book version input.
                    scan.nextLine(); // Consume the newline character left in the input buffer after reading the String.

                    // The student birthDate input
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                    boolean validInput = false; // When the date is entered correctly, the value of this variable becomes true.
                    while (!validInput) {
                        System.out.println("Enter the book date (in format dd/MM/yyyy): ");
                        String userInput = scan.nextLine();
                        Date parsedDate;
                        try {
                            parsedDate = date.parse(userInput); //parsing the String to a Date Format.
                            System.out.println("Parsed Date: " + parsedDate);
                            validInput = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
                        }
                    }

                    // The Book Author input.
                    System.out.println("Enter the book author name: ");
                    String authorName = scan.nextLine();

                    Author author = new Author();
                    // Checking if the Author is exists in the System.
                    if (library.searchByAuthor(authorName).isEmpty()) { // Author not found
                        System.out.println("We did't found this author in our system, Please enter the rest of author data to add it to this System.");
                        System.out.println("Enter the Author address: ");
                        String authorAddress = scan.nextLine();

                        // The bookAuthor birthDate input
                        SimpleDateFormat authorBirthDate = new SimpleDateFormat("dd/MM/yyyy");
                        boolean validInput2 = true; // When the date is entered correctly, the value of this variable becomes false.
                        while (validInput2) {
                            System.out.println("Enter the Author birth date (in format dd/MM/yyyy): ");
                            String userInput2 = scan.nextLine();
                            Date parsedDate2;
                            try {
                                parsedDate2 = authorBirthDate.parse(userInput2); //parsing the String to a Date Format.
                                System.out.println("Parsed Date: " + parsedDate2);
                                validInput2 = false;
                            } catch (ParseException e) {
                                System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
                            }
                            //Add the author.
                            author = new Author(authorName, authorAddress, authorBirthDate);

                        }
                    } else {
                        author = library.getAuthorByName(authorName);
                    }

                    // Confirm adding the author.
                    System.out.println("Are you shure to add the Book " + title
                            + "\n" + "Genre : " + genre
                            + "\n" + "Version: " + version
                            + "\n" + "Date: " + date
                            + "\n" + "Author: " + authorName
                            + "\n" + "press (y) or (Y) for yes, or any another key to cancel.");
                    String inputKey = scan.nextLine(); //The Book Addition Confirmation Key.

                    //Print the confirmation result.
                    if (inputKey.equalsIgnoreCase("Y")) {
                        System.out.println("The Book " + title + " is added to the system :). ");
                    } else {
                        System.out.println("The add request is canceled");
                        break;
                    }
                    Book book = new Book(title, author, genre, version, date); //Create a new Book object.
                    library.addBook(book); //Add the new Book to the ArrayList books.

                }
                //--------------------------------------------------------------------------------------------------------------
                //Loan a Book.
                case 3 -> {

                    System.out.println("Would you like to search for the book by (1) Name or (2) Number?");
                    int searchChoice = scan.nextInt();
                    scan.nextLine(); // Consume the newline character left in the buffer.
                    Book bookToLoan = null;

                    if (searchChoice == 1) {
                        System.out.println("Enter book title to search: ");
                        String bookTitle = scan.nextLine(); // Read the book title.
                        bookToLoan = library.searchByTitle(bookTitle);
                        if (bookToLoan == null) {
                            System.out.println("Book not found!");
                            break; // Exit the case if the book doesn't exist.
                        }
                    } else if (searchChoice == 2) {
                        System.out.println("Enter book number to loan: ");
                        int bookNo = scan.nextInt(); // Read the book number.
                        scan.nextLine(); // Consume the newline character left in the buffer.
                        bookToLoan = library.searchByNo(bookNo);
                        if (bookToLoan == null) {
                            System.out.println("Book not found!");
                            break; // Exit the case if the book doesn't exist.
                        }
                    } else {
                        System.out.println("Invalid search option.");
                        break;
                    }

                    System.out.println("Enter the student id: ");
                    int studentId = scan.nextInt(); // Read the student id.
                    scan.nextLine(); // Consume the newline character left in the buffer.

                    Student student = library.findStudentById(studentId); // Find the student with the given id.
                    if (student == null) {
                        System.out.println("Student not found!");
                        break; // Exit the case if the student doesn't exist.
                    }

                    // Attempt to loan the book to the student.
                    boolean loanSuccess = library.loanBook(student, bookToLoan);
                    if (loanSuccess) {
                        System.out.println("Book loaned successfully to " + student.getName() + "!");
                    } else {
                        System.out.println("Could not loan the book. The book might already be on loan, or the student has reached their loan limit.");
                    }

                }
                //--------------------------------------------------------------------------------------------------------------
                // Return Book

                case 4 -> {
                    System.out.println("Enter the book's number to return: ");
                    int bookNo = scan.nextInt();
                    Book bookToReturn = library.searchByNo(bookNo);
                    if (bookToReturn == null) {
                        System.out.println("Book not found!");
                    } else {
                        boolean returnSuccess = library.returnBook(bookToReturn);
                        if (returnSuccess) {
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Failed to return the book.");
                        }
                    }

                }
                //--------------------------------------------------------------------------------------------------------------
                // Search Book by Title.

                case 5 -> {
                    System.out.println("Enter book title to search: ");
                    String bookTitle = scan.nextLine();

                    Book foundBook = library.searchByTitle(bookTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getInfo());
                    } else {
                        System.out.println("No book found with the given title.");
                    }
                }
                //--------------------------------------------------------------------------------------------------------------
                // Search Book by Author.

                case 6 -> {
                    System.out.println("Enter author's name to find their books: ");
                    String authorName = scan.nextLine();
                    List<Book> foundBooks = library.searchByAuthor(authorName);
                    if (!foundBooks.isEmpty()) {
                        for (Book b : foundBooks) {
                            System.out.println(b.getInfo());
                        }
                    } else {
                        System.out.println("No books found for the given author.");
                    }
                }
                //--------------------------------------------------------------------------------------------------------------
                // Search Book by No.

                case 7 -> {
                    System.out.println("Enter book number to search: ");
                    int bookNumber = scan.nextInt();
                    Book foundBook = library.searchByNo(bookNumber);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getInfo());
                    } else {
                        System.out.println("No book found with the given number.");
                    }
                }
                //--------------------------------------------------------------------------------------------------------------
                // Loaned books list.

                case 8 -> {
                    Collection<Loan> loans = library.getLoans();
                    if (loans.isEmpty()) {
                        System.out.println("There are no loaned books at the moment.");
                    } else {
                        for (Loan loan : loans) {
                            System.out.println("Book" + loan.getBook().getTitle() +
                                 " loaned by student: " + loan.getStudent().getName() + "with ID: "+loan.getStudent().getId());
                        }
                    }
                }
                //--------------------------------------------------------------------------------------------------------------
                // Search if a Book is Loaned.

                case 9 -> {
                    System.out.println("Enter book title to search: ");
                    String bookTitle = scan.nextLine();

                    Book foundBook = library.searchByTitle(bookTitle);
                    if (foundBook == null) {
                        System.out.println("No book found with the given title.");
                    } else {
                        if (foundBook.inLoan()) {
                            System.out.println("The Book with title "+ bookTitle +"is loaned.");
                        } else {
                            System.out.println("The Book with title" + bookTitle + "is not loaned.");
                        }
                    }
                }
                //--------------------------------------------------------------------------------------------------------------
                // Exit the app.

                case 10 -> {
                    System.out.println("Exiting... Thank you!");
                }
                default ->
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println("  "
                    + "");

        } while (choice != 10);
    }
}
