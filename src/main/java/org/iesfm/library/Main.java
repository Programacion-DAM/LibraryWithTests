package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Library library = new Library("Mi libereria", new Book[0], new Member[0], new BookLend[0]);

        try {
            library.showMember("");
        } catch(Exception e) {
            System.out.println("error");
        }

    }

    static Book readBook() {
        Book book = null;
        while (book == null) {
            String title = scan.nextLine();
            String author = scan.nextLine();
            int isbn = readISBN();
            String[] genres = new String[1];
            genres[0] = "Terror";
            book = new Book(isbn, title, author, genres);
        }
        return book;
    }

    static int readISBN() {
        Integer isbn = null;
        System.out.println("Introduce el ISBN");
        while (isbn == null) {
            try {
                isbn = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El ISBN debe ser un número");
            } finally {
                scan.nextLine();
            }
        }
        return isbn;
    }


}
