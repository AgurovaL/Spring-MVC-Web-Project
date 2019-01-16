package dbActions;

import dbActions.dbModels.Book;
import dbActions.dbModels.User;
import dbActions.repositories.BookRepository;
import dbActions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void saveUsers() {
        User user = User.create("John", "Snow", "Black Castle", "john", "johnsnow1");

        Book book = Book.create("The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300 );
        Set<Book> set = new HashSet<>();
        set.add(book);

        user.setBooks(set);
        userRepository.save(user);
        System.out.println(" -- user has been saved --");
    }

    public void findUsers() {
        System.out.println(" -- finding all users --");
        userRepository.findAll().forEach(System.out::println);
    }

    public void findUserByName(){
        System.out.println("find user");
        System.out.println(  userRepository.findByFirstName("John").get() );
    }

    @Transactional
    public void saveBooks() {
        Book book = bookRepository.save(Book.create(
                "The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300 ));
        System.out.println(book);
    }
}