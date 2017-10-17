package com.example.dell.reviewone.presenter;

import com.example.dell.reviewone.bean.Bean;
import com.example.dell.reviewone.model.Calls;
import com.example.dell.reviewone.model.MyModel;
import com.example.dell.reviewone.view.Iview;

/**
 * Created by dell on 2017/10/17.
 */

public class Presenter {
    private Iview iview;
    private MyModel myModel;


    public Presenter(Iview iview) {
        this.iview = iview;
        myModel = new MyModel();

    }

    public void sendData(String url) {
        myModel.getDate(url, new Calls() {
            @Override
            public void success(Bean bean) {
                iview.success(bean);
            }

            @Override
            public void failure(Exception e) {
                iview.failure(e);


            }
        });

    }


}
