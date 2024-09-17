package Data.Client;

import Data.Impl.BookImpl;
import Data.Interface.BookInterface;
import Data.Interface.BooksTeacher;
import Data.models.LMSModels.Book;
import Data.models.LMSModels.BookTakenByTeacher;

import java.util.List;

public class LMSInit {
    public void initApp(){
        BookInterface bookimpl =  new BookImpl();
        BooksTeacher bookTeacherImpl =  new BookImpl();
        Book book1 = new Book(15,"Java", "john wick");
        bookimpl.addBook(book1);
        BookTakenByTeacher teacherDetail = new BookTakenByTeacher("Samyam","NY",book1);

        List<Book> gotbooks = bookimpl.getAllBooks();
        bookTeacherImpl.getBook(teacherDetail);
        for (Book b1: gotbooks
             ) {
            System.out.println(b1);
        }
    }
}
