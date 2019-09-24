package com.sinothk.android.views.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sinothk.android.views.MixtureTextView;

public class MixtureTextViewDemoActivity extends AppCompatActivity {

    MixtureTextView mixtureTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixture_text_view_demo);

        mixtureTextView = findViewById(R.id.id_mixtureTextview);
        mixtureTextView.setText(getString(R.string.text2));
    }
}
