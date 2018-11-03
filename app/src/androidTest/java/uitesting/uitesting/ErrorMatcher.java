package uitesting.uitesting;

import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class ErrorMatcher {

    @NonNull

    public static Matcher<View> withError(final Matcher<String> stringMatcher) {

        return new BoundedMatcher<View, TextView>(TextView.class) {


            @Override

            public void describeTo(final Description description) {
                description.appendText("The field is required");
                stringMatcher.describeTo(description);
            }


            @Override

            public boolean matchesSafely(final TextView textView) {
                return stringMatcher.matches(textView.getError().toString());
            }
        };
    }
}