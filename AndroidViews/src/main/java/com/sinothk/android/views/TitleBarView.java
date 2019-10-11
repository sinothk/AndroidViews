package com.sinothk.android.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    private LinearLayout titleBarRootView,tbBackView;
    private View noticeView;
    private RelativeLayout titleBarView;
    private TextView tbTxt;


    private void initView(Context mContext) {
        this.context = mContext;
        view = LayoutInflater.from(mContext).inflate(R.layout.title_bar_layout, null);

        titleBarRootView = view.findViewById(R.id.titleBarRootView);
        noticeView = view.findViewById(R.id.noticeView);
        titleBarView = view.findViewById(R.id.titleBarView);
        //
        tbBackView = view.findViewById(R.id.tbBackView);

        //
        tbTxt = view.findViewById(R.id.tbTxt);

        titleBarRootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(view);
    }

    public void setNoticeViewVisible(int visible) {
        if (noticeView != null) {
            noticeView.setVisibility(visible);
        }
    }

    public void setCenterTxt(String txt) {
        if (tbTxt != null) {
            tbTxt.setText(txt);
        }
    }

    public void setCenterTxtColor(int colorId) {
        if (tbTxt != null) {
            tbTxt.setTextColor(ContextCompat.getColor(context, colorId));
        }
    }
}
