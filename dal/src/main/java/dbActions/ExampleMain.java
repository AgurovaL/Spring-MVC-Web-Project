package dbActions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;

public class ExampleMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DBConfig.class);
        DBService DBService = context.getBean(DBService.class);
        try {
            DBService.saveUsers();
            DBService.saveBooks();
        } catch (Exception e) {
            System.err.println(e);
        }
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        emf.close();
    }
}