package vickypatel.ca.androidstarterkit;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import vickypatel.ca.androidstarterkit.extras.VolleyIdlingResource;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by VickyPatel on 2016-07-17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void ViewVisibilityTest() {
        onView(withId(R.id.testButton)).check(matches(isDisplayed()));
    }

    @Test
    public void buttonClickTest(){
        onView(withText("Test Dagger")).perform(click());

        VolleyIdlingResource volleyResources;
        try {
            volleyResources = new VolleyIdlingResource("VolleyCalls");
            registerIdlingResources(volleyResources);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        onView(withText("Success"))
                .inRoot(withDecorView(not(mainActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));

    }

}
