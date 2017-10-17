package com.example.dell.reviewone.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dell on 2017/10/17.
 */

public class Utils {
    private static Utils utils;
    private final OkHttpClient build;

    private Utils(){
        build = new OkHttpClient.Builder().build();
    }
    public static synchronized Utils getIntance(){
        if (utils==null)
            utils=new Utils();
        return utils;


    }
    public void sendGet(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = build.newCall(request);
        call.enqueue(callback);


    }

}
