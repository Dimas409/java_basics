package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int quantityOfPages;
    private final int numberISBN;

    public Book(String name, String author, int quantityOfPages, int numberISBN) {
        this.name = name;
        this.author = author;
        this.quantityOfPages = quantityOfPages;
        this.numberISBN = numberISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantityOfPages() {
        return quantityOfPages;
    }

    public int getNumberISBN() {
        return numberISBN;
    }
}
