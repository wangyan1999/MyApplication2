package com.example.dell.reviewone.model;

import android.os.Handler;

import com.example.dell.reviewone.bean.Bean;
import com.example.dell.reviewone.utils.Utils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/10/17.
 */

public class MyModel implements IModel{
    private Handler handler=new Handler();
    @Override
    public void getDate(String url, final Calls calls) {
        Utils.getIntance().sendGet(url, new Callback() {

            private String string;

            @Override
            public void onFailure(Call call, IOException e) {
                calls.failure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string = response.body().string();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        Bean bean = gson.fromJson(string, Bean.class);
                        calls.success(bean);
                    }
                },500);


            }
        });

    }
}
