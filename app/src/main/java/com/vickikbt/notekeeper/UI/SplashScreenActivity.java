package com.vickikbt.notekeeper.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vickikbt.notekeeper.Models.Quotes;
import com.vickikbt.notekeeper.R;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView textViewDate, textViewQuote;

    private String mQuotes;

    private Quotes quotes=new Quotes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        textViewDate=findViewById(R.id.textView_date);
        textViewQuote=findViewById(R.id.textView_quote);
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
        mQuotes = quotes.getRandomFact();
        textViewQuote.setText(mQuotes);

    }
}
