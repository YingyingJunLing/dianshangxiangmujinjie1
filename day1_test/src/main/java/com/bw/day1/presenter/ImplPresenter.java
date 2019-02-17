package com.bw.day1.presenter;

import com.bw.day1.MainActivity;
import com.bw.day1.model.ImplModel;
import com.bw.day1.model.Inmodel;

public class ImplPresenter implements InPresenter
{
    MainActivity mainActivity;
    private final ImplModel implModel;

    public ImplPresenter(MainActivity mainActivity)
    {
        //初始化model
        implModel = new ImplModel();
        //初始化view
        this.mainActivity = mainActivity;
    }

    @Override
    public void getPresenterData()
    {
          implModel.getModelData("http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?count=10&page=1", new Inmodel.CallBacks() {
              @Override
              public void success(Object obj) {
                  mainActivity.getData(obj);

              }

              @Override
              public void fail() {

              }
          });
    }
}
