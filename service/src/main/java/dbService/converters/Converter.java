package dbService.converters;

import dbModels.DBModel;
import viewModels.ViewModel;

public interface Converter<M extends DBModel, V extends ViewModel> {
    public M convertFromView(V viewModel);
    public V convertToView(M model);
}
