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
	        implementation 'com.github.sinothk:AndroidViews:1.19.0925'
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
