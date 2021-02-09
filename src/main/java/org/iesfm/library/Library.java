package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Library implements ILibrary {

    private String name;
    private Book[] books;
    private Member[] members;
    private BookLend[] bookLends;

    public Library(String name, Book[] books, Member[] members, BookLend[] bookLends) {
        this.name = name;
        this.books = books;
        this.members = members;
        this.bookLends = bookLends;
    }

    @Override
    public void showBooks() {
        System.out.println("Catálogo de la biblioteca: ");
        for (Book book : books) {
            book.info();
        }
    }

    @Override
    public void showBooks(String genre) {
        System.out.println("Los libros disponibles de " + genre + " son:");
        for (Book book : books) {
            if (book.hasGenre(genre)) {
                book.info();
            }
        }
    }

    @Override
    public Book getBook(int isbn) {
        Book result = null;
        for(Book book: books) {
            if(book.getIsbn() == isbn) {
                result = book;
            }
        }
        return result;
    }

    @Override
    public void showMember(String nif) throws MemberNotFoundException, BookNotFoundException  {
        Member member = findMember(nif);
        member.info();
    }

    private Member findMember(String nif) throws MemberNotFoundException {
        Member result = null;
        for (Member member : members) {
            if (member.getNif().equals(nif)) {
                result = member;
            }
        }

        if (result == null) {
            throw new MemberNotFoundException(nif);
        }

        return result;
    }

    @Override
    public void showMembers() {
        System.out.println("Los socios de la biblioteca son: ");
//        for (int i = 0; i < members.length; i++) {
//            Member member = members[i];
        for (Member member : members) {
            member.info();
        }
    }

    @Override
    public void showMembers(int cp) {
        System.out.println("Los socios de la biblioteca residentes en " + cp + " son:");
        for (Member member : members) {
            if (member.isFrom(cp)) {
                member.info();
            }
        }
    }

    @Override
    public void showMemberLends(String nif) {

    }


    @Override
    public void showMemberLends(int numMember) {

    }

    @Override
    public boolean memberHasLend(int numMember, int isbn) {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public BookLend[] getBookLends() {
        return bookLends;
    }

    public void setBookLends(BookLend[] bookLends) {
        this.bookLends = bookLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Arrays.equals(books, library.books) && Arrays.equals(members, library.members) && Arrays.equals(bookLends, library.bookLends);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(books);
        result = 31 * result + Arrays.hashCode(members);
        result = 31 * result + Arrays.hashCode(bookLends);
        return result;


    }


    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                ", members=" + Arrays.toString(members) +
                ", bookLends=" + Arrays.toString(bookLends) +
                '}';
    }
}
