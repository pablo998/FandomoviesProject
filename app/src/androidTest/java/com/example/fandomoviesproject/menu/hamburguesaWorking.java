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
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class hamburguesaWorking {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void hamburguesaWorking() {
        ViewInteraction textView = onView(
                allOf(withText("Menú"),
                        withParent(allOf(withId(R.id.main_toolbar),
                                withParent(withId(R.id.app_bar)))),
                        isDisplayed()));
        textView.check(matches(withText("Menú")));

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Nav open"),
                        childAtPosition(
                                allOf(withId(R.id.main_toolbar),
                                        childAtPosition(
                                                withId(R.id.app_bar),
                                                0)),
                                0)));
        appCompatImageButton.perform(scrollTo(), click());

        ViewInteraction checkedTextView = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Inicio"),
                        withParent(allOf(withId(R.id.nav_home),
                                withParent(withId(R.id.design_navigation_view)))),
                        isDisplayed()));
        checkedTextView.check(matches(isDisplayed()));

        ViewInteraction checkedTextView2 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Mi Perfil"),
                        withParent(allOf(withId(R.id.nav_perfil),
                                withParent(withId(R.id.design_navigation_view)))),
                        isDisplayed()));
        checkedTextView2.check(matches(isDisplayed()));

        ViewInteraction checkedTextView3 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Favoritos"),
                        withParent(allOf(withId(R.id.nav_fav),
                                withParent(withId(R.id.design_navigation_view)))),
                        isDisplayed()));
        checkedTextView3.check(matches(isDisplayed()));

        ViewInteraction checkedTextView4 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Compras"),
                        withParent(allOf(withId(R.id.nav_cart),
                                withParent(withId(R.id.design_navigation_view)))),
                        isDisplayed()));
        checkedTextView4.check(matches(isDisplayed()));

        ViewInteraction checkedTextView5 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("Ayuda"),
                        withParent(allOf(withId(R.id.nav_help),
                                withParent(withId(R.id.design_navigation_view)))),
                        isDisplayed()));
        checkedTextView5.check(matches(isDisplayed()));
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
