package com.example.firstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        TextView textView = findViewById(R.id.author2);
        String date = "16.02.2019";

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            textView.setText("Author:" +
                    "\n\nName: Denis Lavrenov" +
                    "\nCreated: " + format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
