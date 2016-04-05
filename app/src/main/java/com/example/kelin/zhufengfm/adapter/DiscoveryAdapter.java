package com.example.kelin.zhufengfm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kelin.zhufengfm.fragment.DiscoveryAnchorFragment;
import com.example.kelin.zhufengfm.fragment.DiscoveryCategoryFragment;
import com.example.kelin.zhufengfm.fragment.DiscoveryRadioFragment;
import com.example.kelin.zhufengfm.fragment.DiscoveryRatingFragment;
import com.example.kelin.zhufengfm.fragment.DiscoveryRecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kelin on 2016/4/5.
 */
public class DiscoveryAdapter extends FragmentPagerAdapter {

    List<String> list = new ArrayList<>();



    public DiscoveryAdapter(FragmentManager fm) {
        super(fm);
        list.add("推荐");
        list.add("分类");
        list.add("广播");
        list.add("榜单");
        list.add("主播");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DiscoveryRecommendFragment();
            case 1:
                return new DiscoveryCategoryFragment();
            case 2:
                return new DiscoveryRadioFragment();
            case 3:
                return new DiscoveryRatingFragment();
            case 4:
                return new DiscoveryAnchorFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
