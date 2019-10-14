package com.sinothk.android.views.demo.bigImagePageViewDemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sinothk.android.views.bigImagePageView.SquareViewPagerIndicator;
import com.sinothk.android.views.bigImagePageView.TransformationAdapterWrapper;
import com.sinothk.android.views.demo.R;

/**
 * Fragment with inner view pager and implementation of pager adapter with views.
 */
public class SimpleViewsFragment extends Fragment {

    public static SimpleViewsFragment instance() {
        return new SimpleViewsFragment();
    }

    private ViewPager viewPager;
    private SquareViewPagerIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        viewPager = view.findViewById(R.id.view_pager);
        indicator = view.findViewById(R.id.indicator);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SimplePagerAdapter adapter = new SimplePagerAdapter(getContext());

        TransformationAdapterWrapper wrapper = TransformationAdapterWrapper
                .wrap(getContext(), adapter)
                .rows(10)
                .columns(7)
                .marginTop(getResources().getDimensionPixelSize(R.dimen.margin_top))
                .bitmapScale(0.5f)
                .build();

        viewPager.setAdapter(wrapper);
        viewPager.setPageTransformer(false, wrapper);

        indicator.initializeWith(viewPager);
    }

    @Override
    public void onDestroyView() {
        indicator.reset();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.simple_views);
    }

    private static class SimplePagerAdapter extends PagerAdapter {

        private final int[] drawables = new int[] {
                R.drawable.administrator,
                R.drawable.cashier,
                R.drawable.cook,
                R.drawable.administrator,
                R.drawable.cashier,
                R.drawable.pc_desk_001,
                R.drawable.pc_desk_002,
                R.drawable.cashier,
                R.drawable.pc_desk_001,
        };

        private final Context context;
        private final LayoutInflater inflater;

        public SimplePagerAdapter(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return drawables.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageDrawable(ContextCompat.getDrawable(context, drawables[position]));
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
