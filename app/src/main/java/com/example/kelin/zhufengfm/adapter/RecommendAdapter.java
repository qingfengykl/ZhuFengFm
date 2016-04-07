package com.example.kelin.zhufengfm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kelin.zhufengfm.R;
import com.example.kelin.zhufengfm.model.DiscoveryRecommendItem;
import com.example.kelin.zhufengfm.model.RecommendAlbums;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kelin on 2016/4/6.
 */

/**
 * 发现  推荐 列表adapter
 */
public class RecommendAdapter extends BaseAdapter {

    public static final int TYPE_COUNT = 3;
    public static final int TYPE_RECOMMEND = 0;

    private Context mContext;
    private List<DiscoveryRecommendItem> mItems;

    public RecommendAdapter(Context context, List<DiscoveryRecommendItem> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        int ret = 0;

        DiscoveryRecommendItem item = mItems.get(position);
        if (item instanceof RecommendAlbums) {
            ret = TYPE_RECOMMEND;
        }
        return ret;
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

        switch (getItemViewType(position)) {
            case TYPE_RECOMMEND:
                if (convertView == null) {
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.discovery_recommend_album_item, parent, false);
                }
                RecommendViewHolder holder = (RecommendViewHolder) convertView.getTag();
                if (holder == null) {
                    holder = new RecommendViewHolder(convertView);
                    convertView.setTag(holder);
                }
                setRecommendContent(holder);

                break;
        }
        return convertView;
    }

    private void setRecommendContent(RecommendViewHolder holder) {
        RecommendAlbums items = (RecommendAlbums) (mItems.get(0));
        holder.mHeader.setText(items.getTitle());
        for (int i = 0; i < 3; i++) {
            Picasso.with(mContext).load(items.getAlbums().get(i).getCoverLarge()).into(holder.mImageViews[i]);
            holder.mTitles[i].setText(items.getAlbums().get(i).getTitle());
            holder.mTags[i].setText(items.getAlbums().get(i).getTags());
        }
    }

    private static class RecommendViewHolder {
        public TextView mHeader;
        public TextView[] mTitles = new TextView[3];
        public TextView[] mTags = new TextView[3];
        public ImageView[] mImageViews = new ImageView[3];

        public RecommendViewHolder(View itemView) {

            mHeader = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_header);

            mImageViews[0] = (ImageView) itemView.findViewById(R.id.discovery_recommend_album_item_image1);
            mImageViews[1] = (ImageView) itemView.findViewById(R.id.discovery_recommend_album_item_image2);
            mImageViews[2] = (ImageView) itemView.findViewById(R.id.discovery_recommend_album_item_image3);

            mTitles[0] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_title1);
            mTitles[1] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_title2);
            mTitles[2] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_title3);

            mTags[0] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_tags1);
            mTags[1] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_tags2);
            mTags[2] = (TextView) itemView.findViewById(R.id.discovery_recommend_album_item_tags3);


        }
    }
}
