package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

public interface ILibrary {

    void showBooks();

    void showBooks(String genre);

    Book getBook(int isbn);

    void showMember(String nif) throws MemberNotFoundException, BookNotFoundException;

    void showMembers();

    void showMembers(int cp);

    void showMemberLends(String nif);

    void showMemberLends(int numMember);

    // is has

    boolean memberHasLend(int numMember, int isbn);
}
