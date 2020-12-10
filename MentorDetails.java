package com.killer.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MentorDetails extends AppCompatActivity {

    TextView name,number,address,date;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mentor_details);
        name = (TextView) findViewById(R.id.textView01);
        number = (TextView) findViewById(R.id.textView2);
        address = (TextView) findViewById(R.id.textView3);
        date = (TextView) findViewById(R.id.textView4);
        confirm = (Button) findViewById(R.id.button41);

       /* confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MentorDetails.this);
                builder.setMessage("Your meeting is confirmed");
                builder.setTitle("Alert !");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MentorDetails.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });*/
    }
        public void onConfirm(View view)
        {

            /*AlertDialog.Builder builder = new AlertDialog.Builder(MentorDetails.this);
            builder.setMessage("Your meeting is confirmed");
            builder.setTitle("Alert !");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MentorDetails.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });*/
            // Create the object of
            // AlertDialog Builder class
            AlertDialog.Builder builder
                    = new AlertDialog
                    .Builder(MentorDetails.this);

            // Set the message show for the Alert time
            builder.setMessage("Your meeting is confirmed");

            // Set Alert Title
            builder.setTitle("Alert !");

            // Set Cancelable false
            // for when the user clicks on the outside
            // the Dialog Box then it will remain show
            builder.setCancelable(false);

            // Set the positive button with yes name
            // OnClickListener method is use of
            // DialogInterface interface.

            builder.setPositiveButton(
                            "Yes",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    Intent intent = new Intent(MentorDetails.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });

            // Set the Negative button with No name
            // OnClickListener method is use
            // of DialogInterface interface.
            builder.setNegativeButton(
                            " ",
                            new DialogInterface
                                    .OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which)
                                {

                                    // If user click no
                                    // then dialog box is canceled.
                                    dialog.cancel();
                                }
                            });

            // Create the Alert dialog
            AlertDialog alertDialog = builder.create();

            // Show the Alert Dialog box
            alertDialog.show();
        }

}
