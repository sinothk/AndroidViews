package com.sinothk.android.views;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
    private LinearLayout titleBarRootView;
    private View view, noticeView;
    private RelativeLayout titleBarView;

    // 返回
    private LinearLayout tbLeftView;
    private TextView tbLeftTxt;
    private ImageView tbLeftIcon;

    // 中心
    private TextView tbCenterTxt, tbSubCenterTxt;

    private void initView(Context mContext) {
        this.context = mContext;

        view = LayoutInflater.from(mContext).inflate(R.layout.title_bar_layout, null);

        // 基础
        titleBarRootView = view.findViewById(R.id.titleBarRootView);
        titleBarRootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        noticeView = view.findViewById(R.id.noticeView);
        titleBarView = view.findViewById(R.id.titleBarView);

        // 返回部分
        tbLeftView = view.findViewById(R.id.tbLeftView);
        tbLeftTxt = view.findViewById(R.id.tbLeftTxt);
        tbLeftIcon = view.findViewById(R.id.tbLeftIcon);
        // 中间
        tbCenterTxt = view.findViewById(R.id.tbCenterTxt);
        tbSubCenterTxt = view.findViewById(R.id.tbSubCenterTxt);

        // 加入父视图
        addView(view);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);
    }

    public void setTitleBarViewBg(int tbBg) {
        if (titleBarRootView != null) {
            titleBarRootView.setBackgroundResource(tbBg);
        }
    }

    public void setNoticeViewVisible(int visible) {
        if (noticeView != null) {
            noticeView.setVisibility(visible);
        }
    }

    public void setCenterTxt(String txt) {
        if (tbCenterTxt != null && !TextUtils.isEmpty(txt)) {
            tbCenterTxt.setText(txt);
        }
    }

    public void setCenterSubTxt(String txt) {
        if (tbSubCenterTxt != null && !TextUtils.isEmpty(txt)) {
            tbSubCenterTxt.setText(txt);
            tbSubCenterTxt.setVisibility(VISIBLE);
        } else {
            if (tbSubCenterTxt != null) {
                tbSubCenterTxt.setVisibility(GONE);
            }
        }
    }

    public void setCenterTxtColor(int colorId) {
        if (tbCenterTxt != null) {
            tbCenterTxt.setTextColor(ContextCompat.getColor(context, colorId));
        }
    }

    public void setCenterSubTxtColor(int colorId) {
        if (tbSubCenterTxt != null) {
            tbSubCenterTxt.setTextColor(ContextCompat.getColor(context, colorId));
        }
    }


    public void setLeftViewClickListener(OnClickListener clickListener) {
        if (tbLeftView != null && clickListener != null) {
            tbLeftView.setOnClickListener(clickListener);
        }
    }


}
