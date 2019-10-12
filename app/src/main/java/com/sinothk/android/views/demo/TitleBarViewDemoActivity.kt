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
        titleBarView.setTitleBarViewBg(R.drawable.shape_theme_color_gradient)
        titleBarView.setTitleBarViewBg(R.drawable.tb_bg2)
//        titleBarView.setTitleBarViewBg(R.color.colorPrimary)

        // 中间文字控制
        titleBarView.setCenterTxt("SINOTHK System")
        titleBarView.setCenterSubTxt("共25人")

        titleBarView.setCenterTxtColor(R.color.white)
        titleBarView.setCenterSubTxtColor(R.color.white)

        // 左边View
        titleBarView.setLeftViewClickListener {
            finish()
        }
        titleBarView.setLeftTxt("返回")
        titleBarView.setLeftTxtVisible(View.GONE)
        titleBarView.setLeftTxtColor(R.color.white)
        titleBarView.setLeftIcon(R.drawable.comm_movie_liked)

        // 右边
        titleBarView.setRight1Txt("分享") {
//            XUtils.toast().show("分享")
        }
        titleBarView.setRight1TxtColor(R.color.white)

        titleBarView.setRight2Txt("收藏") {
//            XUtils.toast().show("收藏")
        }
        titleBarView.setRight2TxtColor(R.color.white)

        titleBarView.setRight1Icon(R.drawable.comm_movie_liked) {
//            XUtils.toast().show("setRight1Icon")
        }
        titleBarView.setRight2Icon(R.drawable.comm_movie_liked) {
//            XUtils.toast().show("setRight2Icon")
        }
    }
}
