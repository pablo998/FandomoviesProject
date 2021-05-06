package com.example.fandomoviesproject.menu;

import com.example.fandomoviesproject.app.AppMediator;

import java.lang.ref.WeakReference;

public class MenuPresenter implements MenuContract.Presenter {

    public static String TAG = MenuPresenter.class.getSimpleName();

    private WeakReference<MenuContract.View> view;
    private MenuState state;
    private AppMediator mediator;

    public MenuPresenter(AppMediator mediator) {
        this.mediator = mediator;
        state = mediator.getMenuState();
    }

   /* @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new MenuState();
        }
    */
        // call the model and update the state
        //state.data = model.getStoredData();

        // use passed state if is necessary
        //PreviousToMenuState savedState = getStateFromPreviousScreen();
        //if (savedState != null) {

            // update the model if is necessary
            //model.onDataFromPreviousScreen(savedState.data);

            // update the state if is necessary
            //state.data = savedState.data;
        //}
    //}



    //@Override
    //public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary
        //NextToMenuState savedState = getStateFromNextScreen();
        //if (savedState != null) {

            // update the model if is necessary
            //model.onDataFromNextScreen(savedState.data);

            // update the state if is necessary
            //state.data = savedState.data;
        //}

        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        //view.get().onDataUpdated(state);

    //}

    @Override
    public void moviesButtonClicked() {
        view.get().navigateToMoviesScreen();
    }

    @Override
    public void seriesButtonClicked() {
        //falta implementación
    }

    @Override
    public void documentaryButtonClicked() {
        //falta implementación
    }

   // @Override
    //public void onBackPressed() {
        // Log.e(TAG, "onBackPressed()");
    //}



    @Override
    public void injectView(WeakReference<MenuContract.View> view) {
        this.view = view;
    }

    //private NextToMenuState getStateFromNextScreen() {
        //return mediator.getNextMenuScreenState();
    //}

   // private void passStateToNextScreen(MenuToNextState state) {
        //mediator.setNextMenuScreenState(state);
    //}
/*
    private void passStateToPreviousScreen(MenuToPreviousState state) {
        mediator.setPreviousMenuScreenState(state);
    }

    private PreviousToMenuState getStateFromPreviousScreen() {
        return mediator.getPreviousMenuScreenState();
    }

    @Override
    public void injectView(WeakReference<MenuContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(MenuContract.Model model) {
        this.model = model;
    }

 */

}
