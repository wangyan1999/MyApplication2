package com.example.dell.reviewone.model;

import com.example.dell.reviewone.bean.Bean;

/**
 * Created by dell on 2017/10/17.
 */

public interface Calls {
    void success(Bean bean);
    void failure(Exception e);

}
