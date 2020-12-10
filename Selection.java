package com.killer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

public class Selection extends AppCompatActivity {

    TextView name,address,number,date1;
Button confirm;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection);
        name = (TextView) findViewById(R.id.textView2);
        number = (TextView) findViewById(R.id.textView4);
        address = (TextView) findViewById(R.id.textView3);
        date1 = (TextView) findViewById(R.id.textView5);
        confirm = (Button) findViewById(R.id.button2);

        Intent secIntent = getIntent();
        String mesg = secIntent.getStringExtra("key");
        name.setText(mesg);
        number.setText("437-745-8876");
        address.setText("north yotk");
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        date1.setText(dateString);
    }
}
