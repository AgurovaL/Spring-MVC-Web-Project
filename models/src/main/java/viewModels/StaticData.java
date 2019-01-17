package viewModels;

import java.util.ArrayList;
import java.util.List;

public class StaticData {
    public static final List<ViewUser> USERS_LIST = new ArrayList<>();
    public static final List<ViewBook> BOOKS_LIST = new ArrayList<>();

    static {
        ViewUser viewUser = new ViewUser(1L, "Jon", "Snow", "Black Castle", "jon", "jonsnow1");
        ViewBook viewBook1 = new ViewBook(1L, "The Lord of the Rings", "J. R. Tolkien", "Sun", 1954, 2015, 300, 400);
        ViewBook viewBook2 = new ViewBook(2L, "Witches Abroad", "T. Pratchett", "Sun", 1991, 2003, 260, 500);

        viewUser.getBooks().add(viewBook1);

        USERS_LIST.add(viewUser);
        BOOKS_LIST.add(viewBook1);
        BOOKS_LIST.add(viewBook2);


    }
}
