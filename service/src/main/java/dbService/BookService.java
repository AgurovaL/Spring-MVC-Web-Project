package dbService;

import dbActions.repositories.BookRepositoryImpl;
import dbModels.Book;
import dbService.converters.BookConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import viewModels.ViewBook;

import java.util.ArrayList;
import java.util.List;

@ComponentScan({"dbActions.repositories"})
@Service
public class BookService {
    @Autowired
    BookRepositoryImpl bookRepository;

    public ViewBook save(ViewBook viewBook) {
        Book book = new BookConverter().convertFromView(viewBook);
        bookRepository.save(book);
        return new BookConverter().convertToView(book);
    }

    public List<ViewBook> findAll() {
        List<Book> bookList = bookRepository.findAll();

        List<ViewBook> viewBooksList = new ArrayList<>();
        for (Book book : bookList) {
            viewBooksList.add(new BookConverter().convertToView(book));
        }

        return viewBooksList;
    }

    public ViewBook findById(Long id) {
        Book book = bookRepository.findById(id);
        return new BookConverter().convertToView(book);
    }

    public List<ViewBook> findByTitle(String title) {
        List<Book> bookList = bookRepository.findAllByTitle(title);

        List<ViewBook> viewBooksList = new ArrayList<>();
        for (Book book : bookList) {
            viewBooksList.add(new BookConverter().convertToView(book));
        }

        return viewBooksList;
    }

    public long count() {
        return bookRepository.count();
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public void delete(ViewBook viewBook) {
        bookRepository.delete(new BookConverter().convertFromView(viewBook));
    }
}
