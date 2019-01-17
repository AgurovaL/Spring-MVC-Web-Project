package dbService;

import dbModels.Book;
import org.springframework.stereotype.Service;
import viewModels.StaticData;
import viewModels.ViewBook;

import java.util.List;

@Service
public class BookService {
    public Book save(ViewBook viewBook) {
        Book user = new BookConverter().convertFromView(viewBook);
        return user; //bookRepository.save(user);
    }

    public List<ViewBook> findAll() {
        //List<ViewBook> bookList = bookRepository.findAll();
        //----------------------------------demo
        List<ViewBook> bookList = StaticData.BOOKS_LIST;
        return bookList;
        //----------------------------------demo
    }

    public ViewBook findById(Long id) {
        //Optional<Book> bookOptional = bookRepository.findById(id);
//        Optional<Book> bookOptional = new Optional<>();
//        if (bookOptional.isPresent()){
//            return bookOptional.get();
//        }
//        else {
//            return null;
//        }
        //----------------------------------demo
        ViewBook viewBook = StaticData.BOOKS_LIST.get(1);
        return viewBook;
        //----------------------------------demo
    }

    public ViewBook findByFirstName(String firstName) {
        //Optional<Book> bookOptional = bookRepository.findByFirstName(firstName);
//        Optional<Book> bookOptional = new Optional<>();
//        if (bookOptional.isPresent()){
//            return bookOptional.get();
//        }
//        else {
//            return null;
//        }
        //----------------------------------demo
        ViewBook viewBook = StaticData.BOOKS_LIST.get(1);
        return viewBook;
        //----------------------------------demo
    }

    public ViewBook findByLogin(String login) {
        //Optional<Book> bookOptional = bookRepository.findByFirstName(login);
//        Optional<Book> bookOptional = new Optional<>();
//        if (bookOptional.isPresent()){
//            return bookOptional.get();
//        }
//        else {
//            return null;
//        }
        //----------------------------------demo
        ViewBook viewBook = StaticData.BOOKS_LIST.get(1);
        return viewBook;
        //----------------------------------demo
    }

    public long count() {
        return 0;//bookRepository.count();
    }

    public void deleteById(Long id) {
        //bookRepository.deleteById(id);
    }

    public void delete(ViewBook viewBook) {
        //bookRepository.delete(viewBook);
    }
}
