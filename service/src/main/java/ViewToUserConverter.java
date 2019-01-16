
import dbActions.dbModels.User;
import viewModels.ViewUser;

public class ViewToUserConverter implements ViewToDBConverter<User, ViewUser> {
    public User convert(ViewUser viewUser) {
        return  User.create(
                viewUser.getFirstName(),
                viewUser.getLastName(),
                viewUser.getAddress(),
                viewUser.getLogin(),
                viewUser.getPassword()
        );
    }
}
