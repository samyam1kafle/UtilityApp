package Data.Interface;

import Data.models.LMSModels.Book;
import Data.models.LMSModels.BookTakenByTeacher;

public interface BooksTeacher{
    BookTakenByTeacher getBook(BookTakenByTeacher book);

}
