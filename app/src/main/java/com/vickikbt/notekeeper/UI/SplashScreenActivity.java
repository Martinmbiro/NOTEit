package com.vickikbt.notekeeper.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vickikbt.notekeeper.Models.Quotes;
import com.vickikbt.notekeeper.R;

import java.text.DateFormat;
import java.util.Calendar;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView textViewDate;

    private Quotes quotes=new Quotes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        textViewDate=findViewById(R.id.textView_date);
        TextView textViewQuote = findViewById(R.id.textView_quote);
        Button ok = findViewById(R.id.button_ok);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splash=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(splash);
                finish();
            }
        });

        // Get a random fact and update textView
        String mQuotes = quotes.getRandomFact();
        textViewQuote.setText(mQuotes);

        //Get current date and update textView.
        Calendar calendar=Calendar.getInstance();
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        textViewDate=findViewById(R.id.textView_date);
        textViewDate.setText(currentDate + ".");

    }
}
