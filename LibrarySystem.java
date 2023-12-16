package System;

import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrarySystem {
    private static String[] books = { "DYNAMICS OF RODS", "HANDBOOK OF PARVOVIRUSES", "STRUCTURAL ANYLYSIS",
            "COST ACCOUNTING", "HANDBOOK OF CLASSICAL", "HERPETOLOGY", "CONTEMPORARY FINANCIAL MANAGEMENT",
            "LITERATURE", "MEDICAL ASSISTING", "CHILDRENS DICTIONARY" };
    private static String[] borrowers = new String[10];

    private static Date[] borrowDates = new Date[10];

    private static Date[] returnDates = new Date[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("**********WELCOME TO JAVA LIBRARY**********");
            System.out.println("");
            System.out.println("Enter 1. Borrow a book");
            System.out.println("");
            System.out.println("Enter 2. Return a book");
            System.out.println("");
            System.out.println("Enter 3. View book logs");
            System.out.println("");
            System.out.println("Enter 4. Exit");
            System.out.println("");
            System.out.print("Enter number from 1-4 only :  ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    viewBookLogs();
                    break;
                case 4:
                    System.out.println("THANKYOU FOR USING THE LIBRARY SYSTEM!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    private static void borrowBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("*****BOOKS AVAILABLE FOR BORROWING*****");
        System.out.println("");
        for (int i = 0; i < books.length; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        System.out.println("");
        System.out.println("Enter the book number you want to borrow : ");
        System.out.println("");
        int bookNumber = scanner.nextInt();

        if (bookNumber < 1 || bookNumber > books.length) {
            System.out.println("");
            System.out.println("Invalid book number. Please try again.");
            System.out.println("");
            return;
        } else if (borrowers[bookNumber - 1] != null) {
            System.out.println("");
            System.out.println("Sorry, The Book is already borrowed by " + borrowers[bookNumber - 1] + ".");
            return;
        }

        System.out.print("Enter your name: ");
        String borrowerName = scanner.next();
        borrowers[bookNumber - 1] = borrowerName;
        borrowDates[bookNumber - 1] = new Date();

        System.out.println(borrowerName + " Successfully Borrowed " + books[bookNumber - 1] + ".");
    }

    private static void returnBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of Borrower : ");
        String borrowerName = scanner.next();

        int bookNumber = -1;
        for (int i = 0; i < borrowers.length; i++) {
            if (borrowers[i] != null && borrowers[i].equals(borrowerName)) {
                bookNumber = i;
                break;
            }
        }

        if (bookNumber == -1) {
            System.out.println("");
            System.out.println("Sorry, The borrower name was not found. Please try again.");
            return;
        }
        System.out.println("");
        System.out.println("You have succesSfully returned " + books[bookNumber] + ".");
        borrowers[bookNumber] = null;
        returnDates[bookNumber] = new Date();
    }

    private static void viewBookLogs() {
        System.out.println("");
        System.out.println("Book logs:");
        System.out.println("");
        System.out.println(
                "Book Title                    " + "Borrower Name                    " + "Borrow Date           ");

        for (int i = 0; i < books.length; i++) {
            if (borrowers[i] != null) {
                String borrowDateStr = borrowDates[i].toString();
                System.out.println(books[i] + "\t" + borrowers[i] + "\t" + borrowDateStr);
            }

        }

    }
}
