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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class menuToPeliculasToBuscarPelis {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void menuToPeliculasToBuscarPelis() {
        ViewInteraction textView = onView(
                allOf(withText("Menú"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView.check(matches(withText("Menú")));

        ViewInteraction cardView = onView(
                allOf(withId(R.id.moviesButton),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        cardView.perform(scrollTo(), click());

        ViewInteraction textView2 = onView(
                allOf(withText("Peliculas"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView2.check(matches(withText("Peliculas")));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.searchTool), withContentDescription("Buscar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main_toolbar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withText("Buscar película"),
                        withParent(allOf(withId(R.id.toolbar),
                                withParent(withId(R.id.appbar)))),
                        isDisplayed()));
        textView3.check(matches(withText("Buscar película")));

        ViewInteraction textView4 = onView(
                allOf(withId(android.R.id.title), withText("PELÍCULA"),
                        withParent(withParent(withId(android.R.id.tabs))),
                        isDisplayed()));
        textView4.check(matches(withText("PELÍCULA")));
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
