package services.impl;

import model.Book;
import model.Library;
import services.BookService;

import java.util.Map;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

    private final Library library;

    public BookServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public String addBook(Book book) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter ISBN: ");
        book.setISBN(scanner.nextLine());
        System.out.print("enter title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("enter author: ");
        book.setAuthor(scanner.nextLine());
        library.books.put(book.getISBN(), book);
        return "successfully";
    }

    @Override
    public String remove(String ISBN) {
        for (String s: library.books.keySet()) {
            if (s.equalsIgnoreCase(ISBN)){
                library.books.remove(s);
                return "successfully deleted";
            }
        }
        return "not found";
    }

    @Override
    public Book searchBook(String keyWord) {
        for (String s : library.books.keySet()){
            if (s.equalsIgnoreCase(keyWord)){
                return library.books.get(s);
            }
        }
        return null;
    }

    @Override
    public Map<String, Book> displayBooks() {
        return library.books;
    }
}
