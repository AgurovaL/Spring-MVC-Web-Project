package dbService;

import dbActions.dbModels.Book;
import viewModels.ViewBook;

public class BookConverter implements Converter<Book, ViewBook> {
    public Book convertFromView(ViewBook viewBook) {
        return Book.create(
                viewBook.getTitle(),
                viewBook.getAuthor(),
                viewBook.getPublisher(),
                viewBook.getYearOfWriting(),
                viewBook.getYearOfPublishing(),
                viewBook.getPagesNumber()
        );
    }

    public ViewBook convertToView(Book book) {
        return new ViewBook(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getYearOfWriting(),
                book.getYearOfPublishing(),
                book.getPagesNumber()
        );
    }
}
