package dbService.converters;

import dbModels.BuyingOperation;
import viewModels.ViewBuyingOperation;

public class BuyingOperationConverter implements Converter<BuyingOperation, ViewBuyingOperation> {
    public BuyingOperation convertFromView(ViewBuyingOperation viewBuyingOperation) {
        return new BuyingOperation(
                viewBuyingOperation.getBookId(),
                viewBuyingOperation.getUserId(),
                viewBuyingOperation.getDate()
        );
    }

    public ViewBuyingOperation convertToView(BuyingOperation buyingOperation) {
        return new ViewBuyingOperation(
                buyingOperation.getId(),
                buyingOperation.getBookId(),
                buyingOperation.getUserId(),
                buyingOperation.getDate()
        );
    }
}
