package com.example.fandomoviesproject.seriesDeUnaCategoria;

import com.example.fandomoviesproject.data.CategorySerieItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import java.lang.ref.WeakReference;

interface SerieListContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displaySerieListData(SerieListViewModel viewModel);

        void navigateToSerieDetailScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);
        void injectModel(Model model);

        void selectSerieListData(SerieItemCatalog item);
        void fetchSerieListData();
    }

    interface Model {
        void fetchSerieListData(
                CategorySerieItemCatalog category, RepositoryContract.GetSeriesListCallback callback);
    }

}
