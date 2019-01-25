package dbService.converters;

import dbModels.Book;
import dbModels.User;
import viewModels.UserAccount;
import viewModels.ViewBook;
import viewModels.ViewUser;

public class UserConverter implements Converter<User, ViewUser> {
    public User convertFromView(ViewUser viewUser) {
        User newUser = User.create(
                viewUser.getId(),
                viewUser.getFirstName(),
                viewUser.getLastName(),
                viewUser.getAddress(),
                viewUser.getLogin(),
                viewUser.getPassword(),
                viewUser.getRole()
        );

        if (!viewUser.getBooks().isEmpty()) {
            for (ViewBook viewBook : viewUser.getBooks()) {
                newUser.getBooks().add(new BookConverter().convertFromView(viewBook));
            }
        }
        return newUser;
    }

    public ViewUser convertToView(User user) {
        ViewUser newViewUser = new ViewUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );

        if (!user.getBooks().isEmpty()) {
            for (Book book : user.getBooks()) {
                newViewUser.getBooks().add(new BookConverter().convertToView(book));
            }
        }
        return newViewUser;
    }

    public UserAccount convertToAccount(User user) {
        return new UserAccount(
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );
    }

    public UserAccount convertViewToAccount(ViewUser viewUser) {
        return new UserAccount(
                viewUser.getLogin(),
                viewUser.getPassword(),
                viewUser.getRole()
        );
    }
}
