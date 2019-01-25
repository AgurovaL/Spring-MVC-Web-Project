package dbService;

import dbActions.repositories.BuyingOperationRepositoryImpl;
import dbModels.BuyingOperation;
import dbService.converters.BuyingOperationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import viewModels.ViewBuyingOperation;

import java.util.ArrayList;
import java.util.List;

@ComponentScan({"dbActions.repositories"})
@Service
public class BuyingOperationService {
    @Autowired
    BuyingOperationRepositoryImpl buyingOperationRepository;

    public ViewBuyingOperation save(ViewBuyingOperation viewBuyingOperation) {
        BuyingOperation book = new BuyingOperationConverter().convertFromView(viewBuyingOperation);
        buyingOperationRepository.save(book);
        return new BuyingOperationConverter().convertToView(book);
    }

    public List<ViewBuyingOperation> findAll() {
        List<BuyingOperation> bookList = buyingOperationRepository.findAll();

        List<ViewBuyingOperation> viewBuyingOperations = new ArrayList<>();
        for (BuyingOperation buyingOperation : bookList) {
            viewBuyingOperations.add(new BuyingOperationConverter().convertToView(buyingOperation));
        }

        return viewBuyingOperations;
    }

    public ViewBuyingOperation findById(Long id) {
        BuyingOperation buyingOperation = buyingOperationRepository.findById(id);
        return new BuyingOperationConverter().convertToView(buyingOperation);
    }

    public void deleteById(Long id) {
        buyingOperationRepository.deleteById(id);
    }
}
