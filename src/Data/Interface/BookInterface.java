package Data.Interface;

import Data.models.LMSModels.Book;

import java.util.List;

public interface BookInterface {
    Book addBook(Book book);
    List<Book> getAllBooks();
}
