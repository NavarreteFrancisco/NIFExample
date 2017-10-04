package org.ieselcaminas.francisco.nifexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterNIF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_nif);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String s = extras.getString("name");
        TextView textView= (TextView) findViewById(R.id.textView2);
        textView.setText(s);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText= (EditText) findViewById(R.id.editText2);
                String str= editText.getText().toString();
                try {
                    Dni dni =new Dni(str);
                    Intent intent = new Intent();
                    intent.putExtra("nif", dni.toFormattedString());
                    setResult(RESULT_OK, intent);
                    finish();
                } catch (NIFException e) {
                    Toast.makeText(getApplicationContext(), "NIF error",Toast.LENGTH_SHORT);
                }
            }
        });


    }
}
