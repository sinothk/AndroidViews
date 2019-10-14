package com.sinothk.android.views.demo.bigImagePageViewDemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sinothk.android.views.demo.R;

/**
 * Main activity.
 */
public class BigImageShowDemoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MainFragment.instance())
                    .commit();
        }
    }
}
