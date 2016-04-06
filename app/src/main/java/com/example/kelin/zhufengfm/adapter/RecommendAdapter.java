package com.example.kelin.zhufengfm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.kelin.zhufengfm.model.DiscoveryRecommendItem;

import java.util.List;

/**
 * Created by kelin on 2016/4/6.
 */

/**
 * 发现  推荐 列表adapter
 */
public class RecommendAdapter extends BaseAdapter {

    private Context mContext;
    private List<DiscoveryRecommendItem> mItems;

    public RecommendAdapter(Context context, List<DiscoveryRecommendItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (mItems != null) {
            count = mItems.size();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
