package dbActions.repositories;


import dbModels.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Transactional(timeout = 10)
    @Override
    <S extends Book> S save(S s);

    @Transactional(timeout = 10)
    @Override
    <S extends Book> Iterable<S> saveAll(Iterable<S> var1);

    @Override
    Optional<Book> findById(Long var1);

    @Override
    Iterable<Book> findAll();

    Iterable<Book> findAllByTitle(Iterable<String> title);

    @Override
    long count();

    @Transactional(timeout = 10)
    @Override
    void deleteById(Long var1);

    @Transactional(timeout = 10)
    @Override
    void delete(Book var1);
}
