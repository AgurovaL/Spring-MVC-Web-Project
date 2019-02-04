package dbService;

import viewModels.ViewBook;

import java.util.List;

public interface IBookService {
    ViewBook save(ViewBook viewBook);

    List<ViewBook> findAll();

    ViewBook findById(Long id);

    List<ViewBook> findByTitle(String title);

    long count();

    void deleteById(Long id);

    void delete(ViewBook viewBook);
}
