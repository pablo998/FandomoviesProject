package com.example.fandomoviesproject.docuDetail;

import java.lang.ref.WeakReference;

public interface DocuDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayDocuDetailData(DocuDetailViewModel viewModel);
        void navigateToURLtrailer(String URLtrailer);
    }

    interface  Presenter{
        void injectView(WeakReference<DocuDetailContract.View> view);
        void injectModel(DocuDetailContract.Model model);

        void onClickTrailerButton();
        void fetchDocuDetailData();
    }

    interface  Model{

    }


}
