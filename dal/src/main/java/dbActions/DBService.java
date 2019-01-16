package dbActions;

import dbActions.dbModels.Book;
import dbActions.dbModels.User;
import dbActions.repositories.BookRepository;
import dbActions.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.awt.image.LookupOp;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
1. components configuration in config() method
2. repository methods
 */

@Component
public class DBService {

    protected static final Logger LOG = Logger.getLogger(DBService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public User saveUser() {
        User newUser = User.create("Jon", "Snow", "Black Castle", "jon", "jonsnow1");
        Book book = Book.create("The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300);
        Set<Book> set = new HashSet<>();
        set.add(book);
        newUser.setBooks(set);

        User savedUser = userRepository.save(newUser);
        if (savedUser == null) {
            LOG.error("error saving user");
        } else {
            LOG.info(" ---- user has been saved ----");
            LOG.info(savedUser);
        }
        return savedUser;
    }

    public Iterable<User> findAllUsers() {
        LOG.info(" -- finding all users --");

        Iterable<User> list = userRepository.findAll();

        for (User user : list) {
            LOG.info(user);
        }
        return list;
    }

    public User findUserByFirstName(String firstName) {
        LOG.info(" -- finding user by first name-- ");

        Optional<User> userOptional = userRepository.findByFirstName(firstName);
        if (userOptional.isPresent()) {
            LOG.info(userOptional.get());
            return userOptional.get();
        } else {
            LOG.error("smth went wrong");
            return null;
        }
    }

    public User findUserByLogin(String login){
        LOG.info(" -- finding user by login -- ");

        Optional<User> userOptional = userRepository.findByLogin(login);

        if (userOptional.isPresent()) {
            LOG.info(userOptional.get());
            return userOptional.get();
        } else {
            LOG.error("smth went wrong");
            return null;
        }

    }

    @Transactional
    public Book saveBook() {
        Book newBook = Book.create(
                "The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300);

        User newUser = User.create("Jon", "Snow", "Black Castle", "jon", "jonsnow1");
        Set<User> set = new HashSet<>();
        set.add(newUser);
        newBook.setClients(set);

        Book savedBook = bookRepository.save(newBook);

        LOG.info(" -- book has been saved --");
        LOG.info(savedBook);

        return savedBook;
    }
}