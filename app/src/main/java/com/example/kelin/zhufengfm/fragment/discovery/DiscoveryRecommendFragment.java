package com.example.kelin.zhufengfm.fragment.discovery;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kelin.zhufengfm.R;
import com.example.kelin.zhufengfm.adapter.RecommendAdapter;
import com.example.kelin.zhufengfm.fragment.BaseFragment;
import com.example.kelin.zhufengfm.model.DiscoveryRecommendItem;
import com.example.kelin.zhufengfm.model.RecommendAlbums;
import com.example.kelin.zhufengfm.tasks.DiscoveryRecommendTask;
import com.example.kelin.zhufengfm.tasks.TaskCallBack;
import com.example.kelin.zhufengfm.tasks.TaskResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现  推荐部分
 */
public class DiscoveryRecommendFragment extends BaseFragment implements TaskCallBack {

    private RecommendAdapter mAdapter;

    private List<DiscoveryRecommendItem> mItems;

    public DiscoveryRecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new ArrayList<>();
        mAdapter = new RecommendAdapter(getContext(),mItems);
        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);
        task.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.discovery_recommend_fragment, container, false);

        ListView listView = (ListView) ret.findViewById(R.id.discovery_recommend_list);

        listView.setAdapter(mAdapter);


        return ret;
    }

    @Override
    public String getFragmentTitle() {
        return "推荐";
    }

    @Override
    public void onTaskFinished(TaskResult result) {
        if (result != null) {
            int state = result.state;
            if (state==0) {
                Object data = result.data;
                if (data != null) {

                    if (data instanceof JSONObject) {
                        JSONObject jsonObject = (JSONObject) data;

                        try {
                            //获取小编推荐
                            JSONObject object = jsonObject.getJSONObject("editorRecommendAlbums");
                            RecommendAlbums albums = new RecommendAlbums();
                            albums.parseJson(object);
                            mItems.add(albums);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mAdapter.notifyDataSetChanged();
                    }

                }
            }else if (state==8) {
                Snackbar.make(getView(),"网络无响应",Snackbar.LENGTH_SHORT).show();
            }else if (state==9) {
                Snackbar.make(getView(),"服务器数据错误",Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}
