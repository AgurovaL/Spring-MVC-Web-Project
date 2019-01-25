package dbService;

import dbActions.repositories.UserRepositoryImpl;
import dbModels.User;
import dbService.converters.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import viewModels.ViewUser;

import java.util.ArrayList;
import java.util.List;

@Service
@ComponentScan({"dbActions.repositories"})
public class UserService implements UserDetailsService {

   // @Autowired
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ViewUser viewUser = findByLogin(username);
        return new UserConverter().convertViewToAccount(viewUser);
    }

    public ViewUser save(ViewUser viewUser) {
        User user = new UserConverter().convertFromView(viewUser);
        userRepository.save(user);
        return new UserConverter().convertToView(user);
    }

    public List<ViewUser> findAll() {
        List<User> usersList = userRepository.findAll();

        List<ViewUser> viewUsersList = new ArrayList<>();
        for (User user : usersList) {
            viewUsersList.add(new UserConverter().convertToView(user));
        }

        return viewUsersList;
    }

    public ViewUser findById(Long id) {
        User user = userRepository.findById(id);
        return new UserConverter().convertToView(user);
    }

    public ViewUser findByFirstName(String firstName) {
        User user = userRepository.findByFirstName(firstName);
        return new UserConverter().convertToView(user);
    }

    public ViewUser findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        return new UserConverter().convertToView(user);
    }

    public long count() {
        return userRepository.count();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(ViewUser viewUser) {
        userRepository.delete(new UserConverter().convertFromView(viewUser));
    }
}
