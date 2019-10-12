package com.sinothk.android.views.demo;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_title_bar_view_demo.*

class TitleBarViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_bar_view_demo)
//        StatusBarUtil.transparencyBar(this)

        // 设置背景
        titleBarView.setTitleBarViewBg(R.color.colorPrimary)

        titleBarView.setNoticeViewVisible(View.GONE)
        titleBarView.setCenterTxt("SINOTHK")
        titleBarView.setCenterTxtColor(R.color.white)
    }
}
