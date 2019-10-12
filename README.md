# AndroidWidgets
# 引入
## Step 1. Add the JitPack repository to your build file
  Add it in your root build.gradle at the end of repositories:
  
	    allprojects {
	      repositories {
		...
		maven { url 'https://www.jitpack.io' }
	      }
	    }

## Step 2. Add the dependency
	dependencies {
	        // implementation 'com.github.sinothk:AndroidViews:1.19.0925'
		
		// 兼容：Androidx
		implementation 'com.github.sinothk:AndroidViews:2.x.1012'
	}

# 使用1: 图文混编 MixtureTextView
## XML
    <com.sinothk.android.views.MixtureTextView
          android:id="@+id/id_mixtureTextview"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:padding="16dp"
          android:text="@string/text1"
          android:textColor="#333333"
          android:textSize="14sp">

          <ImageView
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_alignParentRight="true"
              android:src="@mipmap/ic_launcher_round" />

          <ImageView
              android:layout_width="100dp"
              android:layout_height="100dp"
              android:padding="16dp"
              android:src="@mipmap/ic_launcher_round" />

          <ImageView
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_marginLeft="100dp"
              android:layout_marginTop="100dp"
              android:src="@mipmap/ic_launcher_round" />
      </com.sinothk.android.views.MixtureTextView>
## java
    mixtureTextView = findViewById(R.id.id_mixtureTextview);
    mixtureTextView.setText(getString(R.string.text2));
    
# 使用2: LoadingTipView
## XML
        <com.sinothk.android.views.LoadingTipView
        android:id="@+id/loadTipTv"
        android:layout_width="match_parent"
        android:background="#FFFF"
        android:layout_height="match_parent"/>

## JAVA
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
        
  # 使用3: ScrollChangeView
        setOnScrollChange

# 使用5: TitleBarView
   ## 布局：
	<com.sinothk.android.views.TitleBarView
        android:id="@+id/titleBarView"
        android:layout_width="match_parent"
        android:layout_height="@dimen/dp_70"
	android:background="@color/transparent" />
	
   ## java
   	StatusBarUtil.transparencyBar(this)

        // 设置背景
        titleBarView.setTitleBarViewBg(R.drawable.shape_theme_color_gradient)
        titleBarView.setTitleBarViewBg(R.drawable.tb_bg2)
	// titleBarView.setTitleBarViewBg(R.color.colorPrimary)

        // 中间文字控制
        titleBarView.setCenterTxt("我的好友")
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
            XUtils.toast().show("分享")
        }
        titleBarView.setRight1TxtColor(R.color.white)

        titleBarView.setRight2Txt("收藏") {
            XUtils.toast().show("收藏")
        }
        titleBarView.setRight2TxtColor(R.color.white)

        titleBarView.setRight1Icon(R.drawable.comm_movie_liked) {
            XUtils.toast().show("setRight1Icon")
        }
        titleBarView.setRight2Icon(R.drawable.comm_movie_liked) {
            XUtils.toast().show("setRight2Icon")
        }
       
