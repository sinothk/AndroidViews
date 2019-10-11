package com.sinothk.android.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class TitleBarView extends LinearLayout {

    public TitleBarView(Context context) {
        super(context);
        initView(context);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private Context context;
    private View view;

    private LinearLayout titleBarRootView;
    private View noticeView;
    private RelativeLayout titleBarView;

    private void initView(Context mContext) {
        this.context = mContext;
        view = LayoutInflater.from(mContext).inflate(R.layout.title_bar_layout, null);

        titleBarRootView = view.findViewById(R.id.titleBarRootView);
        noticeView = view.findViewById(R.id.noticeView);
        titleBarView = view.findViewById(R.id.titleBarView);

        addView(view);
    }

    public void setNoticeViewVisible(int visible) {
        if (noticeView != null) {
            noticeView.setVisibility(visible);
        }
    }
}
