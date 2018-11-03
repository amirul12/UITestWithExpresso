package uitesting.uitesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button submit;
    private EditText enterName;


    private TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        enterName = (EditText) findViewById(R.id.etName);
        submit = (Button) findViewById(R.id.btnSubmit);
        showResult = (TextView) findViewById(R.id.tvShowResult);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showResult.setText(enterName.getText().toString());
            }
        });

    }
}
