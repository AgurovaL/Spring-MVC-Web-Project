import dbActions.dbModels.Book;
import viewModels.ViewBook;

public class ViewToBookConverter implements ViewToDBConverter <Book, ViewBook> {
    public Book convert(ViewBook viewBook) {
        return Book.create(
                viewBook.getTitle(),
                viewBook.getAuthor(),
                viewBook.getPublisher(),
                viewBook.getYearOfWriting(),
                viewBook.getYearOfPublishing(),
                viewBook.getPagesNumber()
        );
    }
}
