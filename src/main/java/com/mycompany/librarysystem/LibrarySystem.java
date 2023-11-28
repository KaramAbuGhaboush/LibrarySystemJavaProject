/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarysystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Loan Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Search Book by No");
            System.out.println("8. Loaned books list");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scan.nextInt();
            scan.nextLine(); // Consume the newline character.
            
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the student id: ");
                    int id = scan.nextInt(); //The student id input.
                    scan.nextLine(); // // Consume the newline character left in the input buffer after reading the integer.
                    
                    System.out.println("Enter the student name: ");
                    String name = scan.nextLine(); //The student name input.
                    
                    System.out.println("Enter the student address: ");
                    String address = scan.nextLine(); //The student address input.
                    
                    // The student birthDate input
                    SimpleDateFormat birthDate = new SimpleDateFormat("dd/MM/yyyy");
                    boolean validInput = false; // When the date is entered correctly, the value of this variable becomes true.
                    while(!validInput){
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
                    System.out.println("Are you shure to add the student " + name +
                            "\n" + "With ID : " + id + 
                            "\n" + "address: " + address +
                            "\n" + "birth date: " + birthDate +
                            "\n" + "major: " + major + 
                            "\n" + "press (y) or (Y) for yes, or any another key to cancel.");
                    
                    String inputKey = scan.nextLine(); //The student addition confirmation Key.
                    
                     //Print the confirmation result
                    if (inputKey.equalsIgnoreCase("Y"))
                        System.out.println("The student " + name + " is added to the system :). "); 
                    else
                    {
                        System.out.println("The add request is canceled" );
                        break;
                    }
                    Student student = new Student(id, name, address, birthDate, major); //Create a new Student object.
                    library.addStudent(student); //Add the new student to the ArrayList students.
                }
                //--------------------------------------------------------------------------------------------------------------
                //Book Addition
                
                case 2 -> {
                    System.out.println("Enter the Book Title: ");
                    String title = scan.nextLine(); //The Book title input.
                    
                    System.out.println("Enter the Book Genre: ");
                    String genre = scan.nextLine(); //The Book genre input.
                    
                    System.out.println("Enter the Book Version: ");
                    int version = scan.nextInt(); //The Book version input.
                    scan.nextLine(); // Consume the newline character left in the input buffer after reading the String.
                    
                    // The student birthDate input
                    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                    boolean validInput = false; // When the date is entered correctly, the value of this variable becomes true.
                    while(!validInput){
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
                    if (library.searchByAuthor(authorName) == null)  { // Author not found
                        System.out.println("We did't found this author in our system, Please enter the rest of author data to add it to this System");
                        System.out.println("Enter the Author address: ");
                        String authorAddress = scan.nextLine();
                    
                    // The bookAuthor birthDate input
                    SimpleDateFormat authorBirthDate = new SimpleDateFormat("dd/MM/yyyy");
                    boolean validInput2 = false; // When the date is entered correctly, the value of this variable becomes true.
                    while(!validInput2){
                        System.out.println("Enter the Author birth date (in format dd/MM/yyyy): ");
                        String userInput2 = scan.nextLine();
                        Date parsedDate2;
                        try {
                            parsedDate2 = authorBirthDate.parse(userInput2); //parsing the String to a Date Format.
                            System.out.println("Parsed Date: " + parsedDate2);
                            validInput2 = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
                        }
                    //Add the author.
                    author = new Author(authorName, authorAddress, authorBirthDate);
                    
                    }
                    }
                    else {
                        author = library.getAuthorByName(authorName);
                    }
                    
                    
                    // Confirm adding the author.
                    System.out.println("Are you shure to add the Book " + title +
                            "\n" + "Genre : " + genre + 
                            "\n" + "Version: " + version +
                            "\n" + "Date: " + date +
                            "\n" + "Author: " + authorName + 
                            "\n" + "press (y) or (Y) for yes, or any another key to cancel.");
                    String inputKey = scan.nextLine(); //The Book Addition Confirmation Key.
                    
                     //Print the confirmation result.
                    if (inputKey.equalsIgnoreCase("Y"))
                        System.out.println("The Book " + title + " is added to the system :). "); 
                    else
                    {
                        System.out.println("The add request is canceled" );
                        break;
                    }
                    Book book = new Book(title, author, genre, version, date); //Create a new Book object.
                    library.addBook(book); //Add the new Book to the ArrayList books.
                    
                }
                case 3 -> {
                    int choice1;
                    Book book = null;
                    Student student = null;
                    do{
                        System.out.println("Please choose an option"+ "/n"+"1- Enter book number."+"/n"+"2-Enter book title.");
                    
                    choice1 = scan.nextInt();
                switch (choice1) {
                    case 1 -> {   
                        System.out.println("Please enter the book number");
                        int bookNo = scan.nextInt();
                        book = library.searchByNo(bookNo);
                    }
                    case 2 -> {   
                        System.out.println("Please enter the book title");
                        String bookTitle = scan.nextLine();
                        book = library.searchByTitle(bookTitle);
                    }
                    default -> System.out.println("Invalid option");
                }
                    }while(choice1<0 || choice1>2);
                    if(book.inLoan() == true) {
                        System.out.println("Sorry, This book is Loaned!");
                        break;
                    }
                    System.out.println("Please enter the student ID");
                    int studentId = scan.nextInt();
                    student = library.findStudentById(studentId);
                    if(student == null) {
                        System.out.println("The student ID is Invalid");
                        
                    }
                    
                    
                    
   
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                }
                case 7 -> {
                }
                case 8 -> {
                }
                case 9 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
            
                    } while (choice != 9);
    }
}
    
