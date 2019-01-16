package dbService;

import dbActions.DBService;
import dbActions.dbModels.User;
import viewModels.UserAccount;
import viewModels.ViewUser;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public void save(ViewUser viewUser) {
       User user = new UserConverter().convertFromView(viewUser);
       new DBService().saveUser();
    }

    public Iterable<ViewUser> findAllUsers() {
        Iterable<User> usersList = new DBService().findAllUsers();
        List<ViewUser> viewUsersList = new ArrayList<>();

        for (User user: usersList) {
            (viewUsersList).add(new UserConverter().convertToView(user));
        }
        return viewUsersList;
    }

    public ViewUser findUserByFirstName(String firstName) {
        User user = new DBService().findUserByFirstName(firstName);
        return new UserConverter().convertToView(user);
    }

    public UserAccount findUserByLogin(String login){
        User user = new DBService().findUserByLogin(login);

        return new UserConverter().convertToAccount(user);
    }
}
