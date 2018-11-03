package uitesting.uitesting;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;
import android.widget.TextView;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ItemListActivityTest {

    @Rule
    public ActivityTestRule<ItemListActivity> mItemListActivityActivityTestRule = new ActivityTestRule<>(ItemListActivity.class);


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void listLaunchInTheMainActivityAndFindItemInTheList(){

        delay(5000);
        ListView listView = (ListView)mItemListActivityActivityTestRule.getActivity().findViewById(R.id.items_list);

        /*how may list are availble in the list*/
        assertThat(listView.getCount(),is(4));

    }

    @Test
    public void testTheItemNameOfTheList() throws Exception{

        delay(1000);

        ListView listView = (ListView)mItemListActivityActivityTestRule.getActivity().findViewById(R.id.items_list);

        /*check item string of the specific position of the list*/
        assertThat(listView.getItemAtPosition(0), CoreMatchers.<Object>is("Item 1"));

        /* casting String */
        assertThat((String)listView.getItemAtPosition(1), is("Item 2"));

    }

    @Test
    public void itemDetailsWhenAnItemIsClicked(){
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();

        final ListView listView =  (ListView)mItemListActivityActivityTestRule.getActivity().findViewById(R.id.items_list);

        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listView.performItemClick(listView.getChildAt(0), 0, listView.getAdapter().getItemId(0));

            }
        });

        Instrumentation.ActivityMonitor monitor = instrumentation.addMonitor(ItemDetailActivity.class.getName(),null, false);
        Activity itemDetailsActivity =  instrumentation.waitForMonitorWithTimeout(monitor, 5000);

        delay(5000);

        TextView detailsView = (TextView)itemDetailsActivity.findViewById(R.id.item_detail);
        assertThat(detailsView.getText().toString(), is("Item 1"));
    }

    private void delay(long item) {
        try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}