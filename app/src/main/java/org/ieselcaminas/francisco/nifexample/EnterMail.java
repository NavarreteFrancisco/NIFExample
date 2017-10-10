package org.ieselcaminas.francisco.nifexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterMail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_mail);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String s = extras.getString("name");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(s);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText2);
                String str = editText.getText().toString();
                if(isCorrectEmail(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("email", str);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Email incorrect",Toast.LENGTH_SHORT);
                }
            }
        });
    }
    public static boolean isCorrectEmail(String email) {
        if(email.matches("[^\\s&&[^@]]+@[(\\w+\\.\\w+)&&[^@]]+")){
            return true;
        }
        return false;
    }
}
