package uitesting.uitesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        TextView detailView = (TextView) findViewById(R.id.item_detail);
        detailView.setText(getIntent().getStringExtra("detail"));

    }
}
