package Data.Impl;

import Data.Interface.BookInterface;
import Data.Interface.BooksTeacher;
import Data.models.LMSModels.Book;
import Data.models.LMSModels.BookTakenByTeacher;

import java.util.ArrayList;
import java.util.List;

public class BookImpl implements BookInterface, BooksTeacher {
    private List<Book> books = new ArrayList<>();
    private List<BookTakenByTeacher> booksTeacher = new ArrayList<>();

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public BookTakenByTeacher getBook(BookTakenByTeacher book) {
        // logic for writing to get the book here
        System.out.println("here i am !!");
        int parentId = getParentId(book);
        System.out.println("Parent id: "+ parentId);
        return book;
    }
    private int getParentId(BookTakenByTeacher book){
        return book.getId();
    }
}
