package uitesting.uitesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToastMegCheck extends AppCompatActivity {

    EditText etName;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_meg_check);
        etName = (EditText)findViewById(R.id.etTest);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etName.getText())){

                    etName.setError("this filed is require");

                }else {
                    Toast.makeText(ToastMegCheck.this, ""+etName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
