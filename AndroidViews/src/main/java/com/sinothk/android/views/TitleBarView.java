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

    // 返回
    private TextView tbRight1Txt, tbRight2Txt;
    private ImageView tbRight1Icon, tbRight2Icon;

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

        // 返回部分
        tbRight1Txt = view.findViewById(R.id.tbRight1Txt);
        tbRight2Txt = view.findViewById(R.id.tbRight2Txt);
        tbRight1Icon = view.findViewById(R.id.tbRight1Icon);
        tbRight2Icon = view.findViewById(R.id.tbRight2Icon);

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

    public void setLeftVisible(int visible) {
        if (tbLeftView != null) {
            tbLeftView.setVisibility(visible);
        }
    }

    public void setLeftTxt(String txt) {
        if (tbLeftTxt != null && !TextUtils.isEmpty(txt)) {
            tbLeftTxt.setText(txt);
        }
    }

    public void setLeftTxtColor(int txtColorResId) {
        if (tbLeftTxt != null) {
            tbLeftTxt.setTextColor(ContextCompat.getColor(context, txtColorResId));
        }
    }

    public void setLeftTxtVisible(int visible) {
        if (tbLeftTxt != null) {
            tbLeftTxt.setVisibility(visible);
        }
    }

    public void setLeftIcon(int imgResId) {
        if (tbLeftIcon != null) {
            tbLeftIcon.setImageResource(imgResId);
        }
    }


    public void setRight1Txt(String txt, OnClickListener clickListener) {
        if (tbRight1Txt != null) {
            tbRight1Txt.setText(txt);
            tbRight1Txt.setOnClickListener(clickListener);
            tbRight1Txt.setVisibility(VISIBLE);
        }
    }

    public void setRight1TxtColor(int colorId) {
        if (tbRight1Txt != null) {
            tbRight1Txt.setTextColor(ContextCompat.getColor(context, colorId));
        }
    }

    public void setRight2Txt(String txt, OnClickListener clickListener) {
        if (tbRight2Txt != null) {
            tbRight2Txt.setText(txt);
            tbRight2Txt.setOnClickListener(clickListener);
            tbRight2Txt.setVisibility(VISIBLE);
        }
    }

    public void setRight2TxtColor(int colorId) {
        if (tbRight2Txt != null) {
            tbRight2Txt.setTextColor(ContextCompat.getColor(context, colorId));
        }
    }

    public void setRight1Icon(int imgResId, OnClickListener clickListener) {
        if (tbRight1Icon != null) {
            tbRight1Icon.setImageResource(imgResId);
            tbRight1Icon.setOnClickListener(clickListener);
            tbRight1Icon.setVisibility(VISIBLE);
        }
    }

    public void setRight2Icon(int imgResId, OnClickListener clickListener) {
        if (tbRight2Icon != null) {
            tbRight2Icon.setImageResource(imgResId);
            tbRight2Icon.setOnClickListener(clickListener);
            tbRight2Icon.setVisibility(VISIBLE);
        }
    }
}
