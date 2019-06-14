package com.example.ds.loginact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText unm,pass;
    TextView t1;
    int count=2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.textView2);

        t1.setText("Attempt:"+count);
        login();
    }
    public void  login()
    {
        unm=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((unm.getText().toString().equals("root")) && ( pass.getText().toString().equals("root")))
                {
                    Toast.makeText(MainActivity.this,"Login suceessfully",Toast.LENGTH_LONG ).show();
                    Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_LONG ).show();
                    count--;
                    t1.setText("Attempt:"+count);
                    if(count==0)
                    {
                        b1.setEnabled(false);
                    }
                }
            }
        });
    }
}
