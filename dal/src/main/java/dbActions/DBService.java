package dbActions;

import dbActions.dbModels.Book;
import dbActions.dbModels.User;
import dbActions.repositories.BookRepository;
import dbActions.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Set;

/*
1. components configuration in config() method
2. repository methods
 */

@Component
public class DBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public static DBService config() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);
        DBService dbService = context.getBean(DBService.class);
        try {
            dbService.saveUsers();
            //DBService.saveBooks();
        } catch (Exception e) {
            System.err.println(e);
        }
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
        return dbService;
    }

    @Transactional
    public void saveUsers() {
        User newUser = User.create("John", "Snow", "Black Castle", "john", "johnsnow1");

        Book book = Book.create("The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300);
        Set<Book> set = new HashSet<>();
        set.add(book);
        newUser.setBooks(set);

        User savedUser = userRepository.save(newUser);
        System.out.println(" -- users has been saved --");
        System.out.println(savedUser);
    }

    public void findUsers() {
        System.out.println(" -- finding all users --");
        userRepository.findAll().forEach(System.out::println);
    }

    public void findUserByName() {
        System.out.println(" -- find user by first name-- ");
        System.out.println(userRepository.findByFirstName("John").get());
    }

    @Transactional
    public void saveBooks() {
        Book newBook = Book.create(
                "The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300);

        User newUser = User.create("John", "Snow", "Black Castle", "john", "johnsnow1");
        Set<User> set = new HashSet<>();
        set.add(newUser);
        newBook.setClients(set);

        Book savedBook = bookRepository.save(newBook);

        System.out.println(" -- boooks has been saved --");
        System.out.println(savedBook);
    }
}