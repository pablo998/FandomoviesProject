package com.example.fandomoviesproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import com.example.fandomoviesproject.app.AppMediator;
import com.example.fandomoviesproject.menu.MenuActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class MenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityRule = new ActivityTestRule<>(MenuActivity.class);

    private Activity activity;

    Context context =
            InstrumentationRegistry.getInstrumentation().getTargetContext();

    String peliculas = context.getString(R.string.peliculas);

    @Before
    public void setUp() {

        AppMediator.resetInstance();

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        mActivityRule.launchActivity(new Intent());
        activity = mActivityRule.getActivity();
    }

    @After
    public void tearDown() {

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());
            device.setOrientationNatural();

        } catch (RemoteException e) {
        }

        mActivityRule.finishActivity();
    }

    private void rotate() {

        int orientation = activity.getRequestedOrientation();

        if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        } else {
            orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }

        activity.setRequestedOrientation(orientation);

        try {

            UiDevice device = UiDevice.getInstance(getInstrumentation());

            if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                device.setOrientationNatural();

            } else {
                device.setOrientationLeft();
            }

        } catch (RemoteException e) {
        }
    }



    @Test
    public void giroPantalla(){
        //onView(withId(R.id.moviesButton)).perform(click());
        // onView(withId(R.id.main_toolbar)).check( matches(withText(R.string.movies)));

        //GIVEN 
        //encontrándonos en pantalla Menu
        //mostraremos botones pelicula, documentales y series activados
        (onView(withId(R.id.moviesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.seriesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.documentaryButton))).check(matches(isEnabled()));



        //WHEN
        //al girar la pantalla
        rotate();

        //THEN
        //mostraremos botones películas, documentales y series activados
        (onView(withId(R.id.moviesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.seriesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.documentaryButton))).check(matches(isEnabled()));
    }

/*    @Test
    public void pulsarPeliculas(){

        (onView(withId(R.id.moviesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.seriesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.documentaryButton))).check(matches(isEnabled()));


        (onView(withId(R.id.moviesButton))).perform(click());



        (onView(withId(R.id.main_toolbar))).check(matches(withText(peliculas)));

    }*/
}
