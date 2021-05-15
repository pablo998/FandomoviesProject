package com.example.fandomoviesproject.perfil;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.menu.MenuContract;

import java.lang.ref.WeakReference;

public class perfilPresenter implements perfilContract.Presenter {

    public static String TAG = perfilPresenter.class.getSimpleName();

    private WeakReference<perfilContract.View> view;
    private perfilState state;
    private perfilContract.Model model;
    private AppMediator mediator;

    public perfilPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getPerfilState();
    }

    /*@Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new perfilState();
        }

        // call the model and update the state
        state.data = model.getStoredData();

        // use passed state if is necessary
        PreviousToperfilState savedState = getStateFromPreviousScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }
    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        NextToperfilState savedState = getStateFromNextScreen();
        if (savedState != null) {

            // update the model if is necessary
            model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            state.data = savedState.data;
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }

    @Override
    public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    }

    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }
*/


    @Override
    public void injectView(WeakReference<perfilContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(perfilContract.Model model) {
        this.model = model;
    }


}
