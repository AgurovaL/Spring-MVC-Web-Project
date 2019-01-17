package dbActions.repositories;


import dbModels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional(timeout = 10)
    @Override
    <S extends User> S save(S s);

    @Override
    Optional<User> findById(Long var1);

    Optional<User> findByFirstName(String name);

    Optional<User> findByLogin(String login);

    @Override
    long count();

    @Transactional(timeout = 10)
    @Override
    void deleteById(Long var1);

    @Transactional(timeout = 10)
    @Override
    void delete(User var1);

}
