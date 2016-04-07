package com.example.kelin.zhufengfm.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.kelin.zhufengfm.model.FocusImages;

import java.util.List;

/**
 * Created by kelin on 2016/4/7.
 */
public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private List<FocusImages.FoucusImage> mImages;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
