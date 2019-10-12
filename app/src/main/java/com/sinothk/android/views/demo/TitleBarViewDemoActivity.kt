package com.sinothk.android.views.demo;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sinothk.android.utils.StatusBarUtil
import com.sinothk.android.utils.XUtils
import kotlinx.android.synthetic.main.activity_title_bar_view_demo.*

class TitleBarViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_bar_view_demo)

        StatusBarUtil.transparencyBar(this)

        // 设置背景
//        titleBarView.setTitleBarViewBg(R.drawable.tb_bg)
        titleBarView.setTitleBarViewBg(R.color.colorPrimary)

        titleBarView.setCenterTxt("SINOTHK System")
        titleBarView.setCenterSubTxt("共25人")

        titleBarView.setCenterTxtColor(R.color.white)
        titleBarView.setCenterSubTxtColor(R.color.white)

        titleBarView.setLeftViewClickListener {
            finish()
        }


    }
}
