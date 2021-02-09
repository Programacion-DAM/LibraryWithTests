package org.iesfm.library;

import java.util.Objects;

public class BookLend {

    private String memberNif;
    private int isbn;
    private String lendDate;
    private String retrieveDate;

    public BookLend(String memberNif, int isbn, String lendDate, String retrieveDate) {
        this.memberNif = memberNif;
        this.isbn = isbn;
        this.lendDate = lendDate;
        this.retrieveDate = retrieveDate;
    }

    public String getMemberNif() {
        return memberNif;
    }

    public void setMemberNif(String memberNif) {
        this.memberNif = memberNif;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getRetrieveDate() {
        return retrieveDate;
    }

    public void setRetrieveDate(String retrieveDate) {
        this.retrieveDate = retrieveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return isbn == bookLend.isbn && Objects.equals(memberNif, bookLend.memberNif) && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(retrieveDate, bookLend.retrieveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNif, isbn, lendDate, retrieveDate);
    }

    @Override
    public String toString() {
        return "BookLend{" +
                "memberNif='" + memberNif + '\'' +
                ", isbn=" + isbn +
                ", lendDate='" + lendDate + '\'' +
                ", retrieveDate='" + retrieveDate + '\'' +
                '}';
    }
}
