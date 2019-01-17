package dbActions;

import dbActions.repositories.BookRepository;
import dbActions.repositories.UserRepository;
import dbModels.Book;
import dbModels.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Set;

public class DBService {
    public static void doAction() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);

        UserRepository userRepository = context.getBean(UserRepository.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        try {
            //--------------------------demo example
            User newUser = User.create("Jon", "Snow", "Black Castle", "jon", "jonsnow1");
            Book book = Book.create("The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300, 400);
            Set<Book> set = new HashSet<>();
            set.add(book);
            newUser.setBooks(set);
            userRepository.save(newUser);
            //--------------------------demo example
        } catch (Exception e) {
            System.err.println(e);
        }
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}
