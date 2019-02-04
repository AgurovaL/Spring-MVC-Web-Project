package dbService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import viewModels.ViewUser;

import java.util.List;

public interface IUserService extends UserDetailsService {
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    ViewUser save(ViewUser viewUser);

    List<ViewUser> findAll();

    ViewUser findById(Long id);

    ViewUser findByFirstName(String firstName);

    ViewUser findByLogin(String login);

    long count();

    void deleteById(Long id);

    void delete(ViewUser viewUser);
}
