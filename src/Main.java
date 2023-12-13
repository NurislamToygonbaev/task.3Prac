import model.Book;
import model.Library;
import services.BookService;
import services.impl.BookServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);
        Library library = new Library();
        BookService service = new BookServiceImpl(library);


        loop:
        while (true){
            System.out.println("""
                    0. exit
                    1. add book
                    2. remove book
                    3. search book
                    4. display books
                    """);
            try {
                switch (scanner.nextInt()){
                    case 0 -> {break loop;}
                    case 1 -> {
                        Book book = new Book();
                        System.out.println(service.addBook(book));
                    }
                    case 2 -> {
                        System.out.print("enter ISBN: ");
                        String isbn = scanForStr.nextLine();
                        System.out.println(service.remove(isbn));
                    }
                    case 3 -> {
                        System.out.print("enter keyWord: ");
                        String keyWord = scanForStr.nextLine();
                        Book book = service.searchBook(keyWord);
                        if (book == null) System.out.println("net takoi knigi");
                        else System.out.println(book);
                    }
                    case 4 -> System.out.println(service.displayBooks());
                    default -> System.out.println("incorrect button");
                }
            }catch (InputMismatchException e){
                System.out.println("enter valid Integer");
                scanner.next();
            }
        }
    }
}