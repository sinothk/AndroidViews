package com.sinothk.android.views.demo.bigImagePageViewDemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sinothk.android.views.bigImagePageView.SquareViewPagerIndicator;
import com.sinothk.android.views.bigImagePageView.TransformationAdapterWrapper;
import com.sinothk.android.views.demo.R;

/**
 * Fragment with inner view pager and fragments adapter.
 */
public class FragmentsFragment extends Fragment {

    public static FragmentsFragment instance() {
        return new FragmentsFragment();
    }

    private ViewPager viewPager;
    private SquareViewPagerIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        indicator = (SquareViewPagerIndicator) view.findViewById(R.id.indicator);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SimplePagerAdapter adapter = new SimplePagerAdapter(getChildFragmentManager());
        TransformationAdapterWrapper wrapper = TransformationAdapterWrapper
                .wrap(getContext(), adapter)
                .rows(10)
                .columns(7)
                .marginTop(getResources().getDimensionPixelSize(R.dimen.margin_top))
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
        getActivity().setTitle(R.string.fragments);
    }

    private static class SimplePagerAdapter extends FragmentStatePagerAdapter {

        private final int[] drawables = new int[] {
                R.drawable.administrator,
                R.drawable.cashier,
                R.drawable.cook,
                R.drawable.administrator,
                R.drawable.cashier,
                R.drawable.cook,
                R.drawable.administrator,
                R.drawable.cashier,
                R.drawable.cook,
        };

        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PagerFragment.instance(drawables[position]);
        }

        @Override
        public int getCount() {
            return drawables.length;
        }
    }
}
