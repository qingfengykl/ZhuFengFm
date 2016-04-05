package com.example.kelin.zhufengfm.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kelin.zhufengfm.R;
import com.example.kelin.zhufengfm.adapter.DiscoveryAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryFragment extends Fragment implements TabLayout.OnTabSelectedListener {


    private ViewPager mPager;

    public DiscoveryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.discovery_fragment, container, false);
//        1.获取tabBar

        final TabLayout tabBar = (TabLayout) ret.findViewById(R.id.discovery_tab_bar);
        //必须设置OnTabSelectListener
        tabBar.setOnTabSelectedListener(this);
//
//        TabLayout.Tab tab = tabBar.newTab();
//        tab.setText("推荐");
//        tabBar.addTab(tab);
//
//         tab = tabBar.newTab();
//        tab.setText("分类");
//        tabBar.addTab(tab);
//
//         tab = tabBar.newTab();
//        tab.setText("广播");
//        tabBar.addTab(tab);
//
//         tab = tabBar.newTab();
//        tab.setText("榜单");
//        tabBar.addTab(tab);
//
//         tab = tabBar.newTab();
//        tab.setText("主播");
//        tabBar.addTab(tab);

        // TODO: TabLayout 与 ViewPager联动

        mPager = (ViewPager) ret.findViewById(R.id.discovery_fragment_viewpager);
        DiscoveryAdapter adapter = new DiscoveryAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(adapter);
//        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabBar));

        tabBar.setupWithViewPager(mPager);
        return ret;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        if (mPager != null) {
            mPager.setCurrentItem(position);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
