package com.sinothk.android.views.demo.bigImagePageViewDemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sinothk.android.views.demo.R;

/**
 * Single ViewPager's item fragment.
 */
public class PagerFragment extends Fragment {

    private static final String KEY_DRAWABLE = "DRAWABLE";
    private static final String KEY_TEXT = "TEXT";

    private TextView textView;

    public static PagerFragment instance(@DrawableRes int drawableId) {
        Bundle args = new Bundle();
        args.putInt(KEY_DRAWABLE, drawableId);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_item_et, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageDrawable(getContext().getResources().getDrawable(getArguments().getInt(KEY_DRAWABLE)));
        textView = (TextView) view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_TEXT, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(KEY_TEXT));
        }
    }
}
