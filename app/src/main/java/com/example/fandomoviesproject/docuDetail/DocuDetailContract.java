package com.example.fandomoviesproject.docuDetail;

//import com.example.fandomoviesproject.peliculaDetail.PeliculaDetailContract;

import java.lang.ref.WeakReference;

public interface DocuDetailContract {

    interface View {
        void injectPresenter(Presenter presenter);


        void displayDocuDetailData(DocuDetailViewModel viewModel);

    }

    interface  Presenter{
        void injectView(WeakReference<DocuDetailContract.View> view);
        void injectModel(DocuDetailContract.Model model);
        String getDocuName();
        void fetchDocuDetailData();
    }

    interface  Model{

    }


}
