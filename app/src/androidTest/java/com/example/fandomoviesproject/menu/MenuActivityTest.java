package com.example.fandomoviesproject.menu;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.fandomoviesproject.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void menuActivityTest() {
        ViewInteraction cardView = onView(
                allOf(withId(R.id.moviesButton),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        cardView.perform(scrollTo(), click());

        ViewInteraction textView = onView(
                allOf(withText("Peliculas"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView.check(matches(withText("Peliculas")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.categories_movieslist),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.categories_movieslist2),
                        childAtPosition(
                                withId(R.id.frameLayout),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView_nombrePelicula), withText("Interstellar"),
                        withParent(withParent(withId(R.id.pelicula))),
                        isDisplayed()));
        textView2.check(matches(withText("Interstellar")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
