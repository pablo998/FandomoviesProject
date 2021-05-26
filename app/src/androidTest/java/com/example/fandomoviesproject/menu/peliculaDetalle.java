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
import org.hamcrest.core.IsInstanceOf;
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
public class peliculaDetalle {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void peliculaDetalle() {
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

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.categoriaText), withText("Romántico"),
                        withParent(withParent(withId(R.id.categories_movieslist))),
                        isDisplayed()));
        textView3.check(matches(withText("Romántico")));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.categories_movieslist),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.categoriaElegidaText), withText("Romántico"),
                        withParent(withParent(withId(R.id.drawer_layout))),
                        isDisplayed()));
        textView4.check(matches(withText("Romántico")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.categoriaElegidaText), withText("Romántico"),
                        withParent(withParent(withId(R.id.drawer_layout))),
                        isDisplayed()));
        textView5.check(matches(withText("Romántico")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.peliculaTexto), withText("Love Actually"),
                        withParent(withParent(withId(R.id.categories_movieslist2))),
                        isDisplayed()));
        textView6.check(matches(withText("Love Actually")));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.categories_movieslist2),
                        childAtPosition(
                                withId(R.id.frameLayout),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.textView_nombrePelicula), withText("Love Actually"),
                        withParent(withParent(withId(R.id.pelicula))),
                        isDisplayed()));
        textView7.check(matches(withText("Love Actually")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.sinopsisContentPeli), withText("En Londres, poco antes de las Navidades, se entrelazan una serie de historias divertidas y conmovedoras. \"Love, Actually\" es una manera abreviada de decir “Love Actually Is All Around” y éste es precisamente el argumento de la película: mires a donde mires, encontrarás el amor en todas partes. Todos los personajes, cada uno a su manera (un primer ministro, una vieja estrella del rock, una asistenta portuguesa que sólo habla su idioma), están relacionados con los aspectos más divertidos, tristes, ingenuos y estúpidos del amor. "),
                        withParent(allOf(withId(R.id.sinopsis),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView8.check(matches(withText("En Londres, poco antes de las Navidades, se entrelazan una serie de historias divertidas y conmovedoras. \"Love, Actually\" es una manera abreviada de decir “Love Actually Is All Around” y éste es precisamente el argumento de la película: mires a donde mires, encontrarás el amor en todas partes. Todos los personajes, cada uno a su manera (un primer ministro, una vieja estrella del rock, una asistenta portuguesa que sólo habla su idioma), están relacionados con los aspectos más divertidos, tristes, ingenuos y estúpidos del amor. ")));
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
