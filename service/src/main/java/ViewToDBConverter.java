import dbActions.dbModels.DBModel;
import viewModels.ViewModel;

public interface ViewToDBConverter<M extends DBModel, V extends ViewModel> {
    public M convert(V viewModel);
}
