package com.udacity.gradle.buildbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private static final String KEY_JOKE = "JOKE";
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (savedInstanceState == null) {
            joke = getIntent().getStringExtra(KEY_JOKE);
        } else {
            joke = savedInstanceState.getString(KEY_JOKE);
        }

        TextView tvJoke = (TextView) findViewById(R.id.tv_joke);
        tvJoke.setText(joke);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_JOKE, joke);
    }
}
