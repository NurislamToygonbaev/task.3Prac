package services;

import model.Book;

import java.util.Map;

public interface BookService {

    String addBook(Book book);

    String remove(String ISBN);

    Book searchBook(String keyWord);

    Map<String, Book> displayBooks();
}
