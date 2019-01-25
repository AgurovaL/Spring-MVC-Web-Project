package dbService.converters;


import dbModels.Book;
import viewModels.ViewBook;

public class BookConverter implements Converter<Book, ViewBook> {
    public Book convertFromView(ViewBook viewBook) {
        Book newBook = Book.create(
                viewBook.getId(),
                viewBook.getTitle(),
                viewBook.getAuthor(),
                viewBook.getPublisher(),
                viewBook.getYearOfWriting(),
                viewBook.getYearOfPublishing(),
                viewBook.getPagesNumber(),
                viewBook.getPrice()
        );
        return newBook;
    }

    public ViewBook convertToView(Book book) {
        return new ViewBook(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getYearOfWriting(),
                book.getYearOfPublishing(),
                book.getPagesNumber(),
                book.getPrice()
        );
    }
}
