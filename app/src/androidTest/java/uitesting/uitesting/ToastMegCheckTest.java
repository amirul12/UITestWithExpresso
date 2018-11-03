package uitesting.uitesting;

import android.support.test.rule.ActivityTestRule;

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
/*
 *  ****************************************************************************
 *  * Created by : Md Amirul  Islam on 11/3/2018 at 8.11 PM.
 *  * Email : amirul.csejust@gmail.com
 *  *
 *  * Purpose: To test all element of UI
 *  *
 *  * Last edited by : Md Amirul Islam on 11/3/2018.
 *  *
 *  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 *  ****************************************************************************
 */

public class ToastMegCheckTest {


    @Rule
    public ActivityTestRule<ToastMegCheck>  mToastMegCheckTest = new ActivityTestRule<>(ToastMegCheck.class);

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
    public void showEditTextName() {
        // now write in edit text
        onView(withId(R.id.etTest)).perform(typeText("amirul"));

        delay(500);

        // now press b Button

        onView(withId(R.id.btnSubmit)).perform(click());

        // now check toast is properly showing or not
        onView(withText("amirul")).inRoot(withDecorView(not(is(mToastMegCheckTest.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }



    private void delay(long item) {
        try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}