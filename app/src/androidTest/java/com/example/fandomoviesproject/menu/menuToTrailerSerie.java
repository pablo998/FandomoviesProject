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
public class menuToTrailerSerie {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void menuToTrailerSerie() {
        ViewInteraction textView = onView(
                allOf(withText("Menú"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView.check(matches(withText("Menú")));

        ViewInteraction cardView = onView(
                allOf(withId(R.id.seriesButton),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        cardView.perform(scrollTo(), click());

        ViewInteraction textView2 = onView(
                allOf(withText("Series"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView2.check(matches(withText("Series")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.serieText), withText("Románticas"),
                        withParent(withParent(withId(R.id.categories_serieslist))),
                        isDisplayed()));
        textView3.check(matches(withText("Románticas")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.categories_serieslist),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.categoriaElegidaText), withText("Románticas"),
                        withParent(withParent(withId(R.id.drawer_layout))),
                        isDisplayed()));
        textView4.check(matches(withText("Románticas")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.serieText), withText("Pasión de gavilanes"),
                        withParent(withParent(withId(R.id.categories_serieslist2))),
                        isDisplayed()));
        textView5.check(matches(withText("Pasión de gavilanes")));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.categories_serieslist2),
                        childAtPosition(
                                withId(R.id.frameLayout),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textView_nombreSerie), withText("Pasión de gavilanes"),
                        withParent(withParent(withId(R.id.serie))),
                        isDisplayed()));
        textView6.check(matches(withText("Pasión de gavilanes")));

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_trailerSerie), withText("Ver tráiler"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        4),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textView7 = onView(
                allOf(withText("Trailer de la Telenovela Pasión de Gavilanes"),
                        isDisplayed()));
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
