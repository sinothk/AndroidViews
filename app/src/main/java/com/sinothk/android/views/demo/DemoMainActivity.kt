package com.sinothk.android.views.demo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_loading_tip_view_demo.*

/**
 * <pre>
 *  创建:  梁玉涛 2019/8/27 on 9:18
 *  项目: AndroidViewsLib
 *  描述:
 *  更新:
 * <pre>
 */
class DemoMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_loading_tip_view_demo)

        loadTipTv.setLoadIcon(R.drawable.loading_tip_icon_green)
        loadTipTv.showLoading()//"数据加载中..."
        loadTipTv.setRetryListener {
            loadTipTv.showLoading("重新加载中...")

            Handler().postDelayed({

                runOnUiThread {
                    loadTipTv.showEmpty()
                }

            }, 3000)
        }

        Handler().postDelayed({

            runOnUiThread {
                loadTipTv.showEmpty()
            }

        }, 5000)
    }
}