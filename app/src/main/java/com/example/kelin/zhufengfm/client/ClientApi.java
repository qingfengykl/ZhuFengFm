package com.example.kelin.zhufengfm.client;

/**
 * Created by kelin on 2016/4/6.
 */

import com.example.kelin.zhufengfm.utils.HttpUtils;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * 工具类
 * 内部就是所有要调用的接口网络请求
 * 每一个接口，实现一个方法
 * 便于统一管理网址，参数和内容
 * 对于一部任务而言，只要调用方法就行了，不需要考虑网址的问题
 */
public final class ClientApi {

    //  通常软件上线之前都是使用测试服务器。
    //  上线的时候就需要使用正式服务器的地址
    public static final String API_POINT = "http://mobile.ximalaya.com/mobile";

    private ClientApi() {
    }

    /**
     * 获取发现部分的推荐内容
     * 对应接口11
     * @return
     */
    public static String getDiscoveryRecommends(boolean includeActivity,boolean includeSpecial){
        String ret = null;
        // 1. 拼接网址
        StringBuilder sb = new StringBuilder(API_POINT);
        sb.append("/discovery/v1/recommends");
        sb.append("?channel=and-f6");
        sb.append("&device=android");
        sb.append("&includeActivity=").append(includeActivity);
        sb.append("&includeSpecial=").append(includeSpecial);
        sb.append("&scale=2");
        sb.append("&version=4.1.7.1");

        String url = sb.toString();
        // 2. 请求

        byte[] data = HttpUtils.doGet(url);

        // 3. 返回结果

        if (data != null) {
            try {
                ret = new String(data,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }



        return ret;
    }
}
