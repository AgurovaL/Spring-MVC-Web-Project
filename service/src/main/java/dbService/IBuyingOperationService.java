package dbService;

import viewModels.ViewBuyingOperation;

import java.util.List;

public interface IBuyingOperationService {
    ViewBuyingOperation save(ViewBuyingOperation viewBuyingOperation);

    List<ViewBuyingOperation> findAll();

    ViewBuyingOperation findById(Long id);

    void deleteById(Long id);
}
