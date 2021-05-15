package com.example.fandomoviesproject.ayuda;




import java.lang.ref.WeakReference;


public interface AyudaContract {
    interface View {
        void injectPresenter(AyudaContract.Presenter presenter);

        void displayAyudaData(AyudaViewModel viewModel);



    }

    interface Presenter {
        void injectView(WeakReference<AyudaContract.View> view);

        void injectModel(AyudaContract.Model model);

        void fetchAyudaData();

    }


    public interface Model {
    }
}

