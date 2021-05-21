package com.example.fandomoviesproject.docusDeUnaCategoria;

import com.example.fandomoviesproject.data.CategoryDocuItemCatalog;
import com.example.fandomoviesproject.data.CategoryItemCatalog;
import com.example.fandomoviesproject.data.DocuItemCatalog;
import com.example.fandomoviesproject.data.PeliculaItemCatalog;
import com.example.fandomoviesproject.data.RepositoryContract;
import com.example.fandomoviesproject.data.SerieItemCatalog;

import com.example.fandomoviesproject.seriesDeUnaCategoria.SerieListViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

public interface DocuListContract {

    interface View{

        void injectPresenter(DocuListContract.Presenter presenter);

        void displayDocuListData(DocuListViewModel viewModel);

        void navigateToDocuDetailScreen();
    }

    interface Presenter{
        void injectView(WeakReference<DocuListContract.View> view);
        void injectModel(DocuListContract.Model model);

        void fetchDocuListData();
        void selectDocuListData(DocuItemCatalog item);
    }

    interface Model{
        void fetchDocuListData(
                CategoryDocuItemCatalog category, RepositoryContract.GetDocusListCallback callback);
    }
}
