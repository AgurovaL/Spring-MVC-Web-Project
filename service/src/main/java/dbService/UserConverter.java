package dbService;

import dbModels.User;
import viewModels.UserAccount;
import viewModels.ViewUser;

import javax.swing.text.View;

public class UserConverter implements Converter<User, ViewUser> {
    public User convertFromView(ViewUser viewUser) {
        return  User.create(
                viewUser.getFirstName(),
                viewUser.getLastName(),
                viewUser.getAddress(),
                viewUser.getLogin(),
                viewUser.getPassword()
        );
    }

    public ViewUser convertToView(User user) {
        return new ViewUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getLogin(),
                user.getPassword()
        );
    }

    public UserAccount convertToAccount(User user){
        return new UserAccount(
                user.getLogin(),
                user.getPassword()
        );
    }
}
