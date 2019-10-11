package com.sinothk.android.views.demo;

import android.graphics.Color
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View
import kotlinx.android.synthetic.main.activity_title_bar_view_demo.*

class TitleBarViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_bar_view_demo)

        titleBarView.setBackgroundResource(R.mipmap.ic_launcher)

        titleBarView.setNoticeViewVisible(View.GONE)
        titleBarView.setCenterTxt("SINOTHK")
        titleBarView.setCenterTxtColor(R.color.colorAccent)
    }
}
