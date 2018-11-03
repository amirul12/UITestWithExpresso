package uitesting.uitesting;

import android.support.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.core.StringContains;
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
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class AnyStringTestTest {


    @Rule
    public ActivityTestRule<AnyStringTest> mAnyStringTestActivityTestRule = new ActivityTestRule<>(AnyStringTest.class);


    /*
     * Below two method needs if want some DB (Database) or network operation and we need setup some
     * important things like DB connection established or DB close.
     * But now we are not use it
     * */

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void AnyStringTestOfTextViewField(){


        delay(2000);
        /* test any string of the text view in the layout . */
        onView(withId(R.id.tvTest))

        .check(matches(withText(containsString("publishing"))));

    }



    private void delay(long item) {
        try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}