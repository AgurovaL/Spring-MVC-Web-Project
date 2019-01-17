package dbService;

import org.springframework.stereotype.Service;
import viewModels.StaticData;
import viewModels.ViewUser;

import java.util.List;

@Service
public class UserService {
    public ViewUser save(ViewUser viewUser) {

        //User user = new UserConverter().convertFromView(viewUser);
        //userRepository.save(user);
        //return new UserConverter().convertToView(user);

        //----------------------------------demo
        StaticData.USERS_LIST.add(viewUser);
        return viewUser;
        //----------------------------------demo
    }

    public List<ViewUser> findAll() {
        //List<ViewUser> userList = userRepository.findAll();
        //----------------------------------demo
        List<ViewUser> userList = StaticData.USERS_LIST;
        return userList;
        //----------------------------------demo
    }

    public ViewUser findById(Long id) {
        //Optional<User> userOprional = userRepository.findById(id);
//        Optional<User> userOprional = new Optional<>();
//        if (userOprional.isPresent()) {
//            return userOprional.get();
//        } else {
//            return null;
//        }
        //----------------------------------demo
        ViewUser viewUser = StaticData.USERS_LIST.get(0);
        return viewUser;
        //----------------------------------demo
    }

    public ViewUser findByFirstName(String firstName) {
        //Optional<User> userOprional = userRepository.findByFirstName(firstName);
//        Optional<User> userOprional = new Optional<>();
//        if (userOprional.isPresent()) {
//            return userOprional.get();
//        } else {
//            return null;
//        }
        //----------------------------------demo
        ViewUser viewUser = StaticData.USERS_LIST.get(0);
        return viewUser;
        //----------------------------------demo
    }

    public ViewUser findByLogin(String login) {
        //Optional<User> userOprional = userRepository.findByFirstName(login);
        // Optional<User> userOprional = new Optional<>();
        // if (userOprional.isPresent()){
        //    return userOprional.get();
        // }
        // else {
        //    return null;
        // }
        //----------------------------------demo
        ViewUser viewUser = StaticData.USERS_LIST.get(0);
        return viewUser;
        //----------------------------------demo
    }

    public long count() {
        return 0;//userRepository.count();
    }

    public void deleteById(Long id) {
        //userRepository.deleteById(id);
    }

    public void delete(ViewUser viewUser) {
        //userRepository.delete(viewUser);
    }
}
