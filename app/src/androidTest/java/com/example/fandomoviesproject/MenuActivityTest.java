package com.example.fandomoviesproject;

import androidx.test.rule.ActivityTestRule;

import com.example.fandomoviesproject.menu.MenuActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityRule = new ActivityTestRule<>(MenuActivity.class);



    @Test
    public void botonPeliculas(){
        //onView(withId(R.id.moviesButton)).perform(click());
        // onView(withId(R.id.main_toolbar)).check( matches(withText(R.string.movies)));

        //GIVEN 
        //encontrándonos en pantalla Menu
        //mostraremos botones pelicula, documentales y series activados
        (onView(withId(R.id.moviesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.seriesButton))).check(matches(isEnabled()));
        (onView(withId(R.id.documentaryButton))).check(matches(isEnabled()));
    }
}
