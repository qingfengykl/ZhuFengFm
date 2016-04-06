package com.example.kelin.zhufengfm.fragment.discovery;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kelin.zhufengfm.R;
import com.example.kelin.zhufengfm.fragment.BaseFragment;
import com.example.kelin.zhufengfm.tasks.DiscoveryRecommendTask;
import com.example.kelin.zhufengfm.tasks.TaskCallBack;
import com.example.kelin.zhufengfm.tasks.TaskResult;

import org.json.JSONObject;

/**
 * 发现  推荐部分
 */
public class DiscoveryRecommendFragment extends BaseFragment implements TaskCallBack {


    public DiscoveryRecommendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DiscoveryRecommendTask task = new DiscoveryRecommendTask(this);
        task.execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discovery_recommend_fragment, container, false);
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
                        Log.d("ddd", "onTaskFinished: "+ ((JSONObject) data).toString());
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
