package com.sinothk.android.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;


/**
 * <pre>
 *  创建:  梁玉涛 2019/5/29 on 10:12
 *  项目: AndroidBaseLib
 *  描述:
 *  更新:
 * <pre>
 */
public class LoadingTipView extends RelativeLayout {

    private Context context;

    public LoadingTipView(Context context) {
        super(context);
        initView(context);
    }

    public LoadingTipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingTipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingTipView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private View view;
    private TextView loadTipTv;
    private ImageView loadTipIv;
    private ProgressBar progressBar;


    private void initView(Context mContext) {

        this.context = mContext;
        view = LayoutInflater.from(mContext).inflate(R.layout.loading_tip_view, null);

        loadTipIv = view.findViewById(R.id.loadTipIv);
        loadTipTv = view.findViewById(R.id.loadTipTv);
        progressBar = view.findViewById(R.id.progressBar);

        addView(view);
        setGravity(Gravity.CENTER);
    }

    /**
     * 加载中
     */
    public void showLoading() {
        view.setEnabled(false);
        progressBar.setVisibility(VISIBLE);
        loadTipIv.setVisibility(GONE);
    }

    public void showLoading(String msg) {
        showLoading();

        if (!TextUtils.isEmpty(msg)) {
            loadTipTv.setVisibility(VISIBLE);
            loadTipTv.setText(msg);
        }
    }

    /**
     * 当前网络不可用
     */
    public void showNetError() {
        showNetError("当前网络不可用", R.drawable.empty_nodata);
    }

    public void showNetError(String msg, int iconResId) {
        view.setEnabled(true);
        progressBar.setVisibility(GONE);
        loadTipIv.setVisibility(VISIBLE);

        loadTipIv.setImageResource(iconResId);

        loadTipTv.setVisibility(VISIBLE);
        loadTipTv.setText(msg);
    }

    public void showEmpty() {
        showEmpty("暂无数据", R.drawable.empty_nodata);
    }

    public void showEmpty(String msg, int iconResId) {
        view.setEnabled(true);
        progressBar.setVisibility(GONE);
        loadTipIv.setVisibility(VISIBLE);

        loadTipIv.setImageResource(iconResId);

        loadTipTv.setVisibility(VISIBLE);
        loadTipTv.setText(msg);
    }

    public void showError(String msg) {
        showError(msg, R.drawable.empty_nodata);
    }

    public void showError(String msg, int iconResId) {
        view.setEnabled(true);
        progressBar.setVisibility(GONE);
        loadTipIv.setVisibility(VISIBLE);

        loadTipIv.setImageResource(iconResId);

        loadTipTv.setVisibility(VISIBLE);
        loadTipTv.setText(msg);
    }

    public void setRetryListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void showContent() {
        this.setVisibility(GONE);
    }

    public void showContent(View contentView) {
        showContent();
        contentView.setVisibility(VISIBLE);
    }

    public void setLoadIcon(int loadIconRes) {
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(context.getResources().getDrawable(loadIconRes));
        }
    }
}
