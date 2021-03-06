package uitesting.uitesting;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private String mName = "Md amirul Islam" ;



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void TestUserInputScenario(){

        //input in the edit text
        onView(withId(R.id.etName)).perform(typeText(mName));

        //Close soft keyboard

        Espresso.closeSoftKeyboard();

        delay(500);

        //perform button click

        onView(withId(R.id.btnSubmit)).perform(click());
        //checking in text in the text view

        onView(withId(R.id.tvShowResult)).check(matches(withText(mName)));

    }

    @Test
    public void ShowEditTextToastMeg(){

        // now check toast is properly showing or not
        onView(withText("Tariqul")).inRoot(withDecorView(not(is(mainActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }


    private void delay(long item){

        try {
            Thread.sleep(item);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @After
    public void tearDown() throws Exception {

    }
}