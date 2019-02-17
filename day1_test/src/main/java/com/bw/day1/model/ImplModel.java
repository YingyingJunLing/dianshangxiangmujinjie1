package com.bw.day1.model;

import com.bw.day1.bean.Bean;
import com.bw.day1.http.OkHttp;

public class ImplModel implements Inmodel
{

    @Override
    public void getModelData(String url, final CallBacks callBacks) {
        OkHttp.getInstance().doGet(url, Bean.class, new OkHttp.NetCallBack() {
            @Override
            public void LoadSuccess(Object obj) {
                callBacks.success(obj);
            }

            @Override
            public void LoadFail() {
                callBacks.fail();
            }
        });
    }
}
