package org.ieselcaminas.francisco.nifexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button enterNif = (Button) findViewById(R.id.button);
        enterNif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                Intent intent = new Intent(getApplicationContext(), EnterNIF.class);
                intent.putExtra("name", editText.getText().toString());
                startActivityForResult(intent, 1234);
            }
        });
        Button enterEmail= (Button) findViewById(R.id.button2);
        enterEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                Intent intent = new Intent(getApplicationContext(), EnterMail.class);
                intent.putExtra("name", editText.getText().toString());
                startActivityForResult(intent, 12345);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String nif = extras.getString("nif");
            TextView textView= (TextView) findViewById(R.id.textView2);
            textView.setText(nif);
        }
        if (requestCode == 12345 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String email = extras.getString("email");
            TextView textView= (TextView) findViewById(R.id.textView4);
            textView.setText(email);
        }
    }
}
