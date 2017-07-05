package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.udacity.gradle.buildbigger.JokeActivity;

public class MainActivityFragment extends Fragment {
    private static final String KEY_JOKE = "JOKE";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJoke = (Button) root.findViewById(R.id.btn_tell_joke);
        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(new JokeListener() {
                    @Override
                    public void getJoke(String joke) {
                        Intent intent = new Intent(getContext(), JokeActivity.class);
                        intent.putExtra(KEY_JOKE, joke);
                        startActivity(intent);
                    }
                }).execute();
            }
        });
        return root;
    }
}
