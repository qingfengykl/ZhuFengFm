package com.example.kelin.zhufengfm.tasks;

/**
 * Created by kelin on 2016/4/6.
 */

import android.os.AsyncTask;

/**
 * 公共的一部任务的定义，主要处理接口回调的操作
 *
 * 基类
 */

public abstract class BaseTask extends AsyncTask<String,Integer,TaskResult>{

    protected TaskCallBack mCallBack;

    public BaseTask(TaskCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected void onPostExecute(TaskResult result) {
        if (mCallBack != null) {
            mCallBack.onTaskFinished(result);
        }
    }
}
