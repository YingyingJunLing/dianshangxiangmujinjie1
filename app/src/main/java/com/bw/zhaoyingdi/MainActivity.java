package com.bw.zhaoyingdi;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView img;
    private SimpleDraweeView img1;

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//

    }
    public void initView()
    {
        findViewById(R.id.yj).setOnClickListener(this);
        findViewById(R.id.yx).setOnClickListener(this);
        findViewById(R.id.jjs).setOnClickListener(this);
        findViewById(R.id.jzdt).setOnClickListener(this);
        findViewById(R.id.jzjt).setOnClickListener(this);
        findViewById(R.id.cphc).setOnClickListener(this);
        findViewById(R.id.pz).setOnClickListener(this);
        findViewById(R.id.bl).setOnClickListener(this);
        img = findViewById(R.id.img);
        img1 = findViewById(R.id.img1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.yj:
                uri = Uri.parse("http://mobile.bwstudent.com/images/movie/stills/ws/ws1.jpg");
                GenericDraweeHierarchy gg = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setRoundingParams(RoundingParams.fromCornersRadius(20))
                        .build();
                img.setHierarchy(gg);
                DraweeController build=  Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setTapToRetryEnabled(true)
                        .build();
                img.setController(build);
                break;
            case R.id.yx:
                Uri uri1 = Uri.parse("http://mobile.bwstudent.com/images/movie/stills/ws/ws1.jpg");
                GenericDraweeHierarchy gg1 = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setRoundingParams(RoundingParams.asCircle())
                        .build();
                img.setHierarchy(gg1);
                DraweeController yxx=  Fresco.newDraweeControllerBuilder()
                        .setUri(uri1)
                        .setTapToRetryEnabled(true)
                        .build();
                img.setController(yxx);

                break;
            case R.id.bl:
                Uri bl = Uri.parse("http://img0.imgtn.bdimg.com/it/u=2174466817,2277438279&fm=26&gp=0.jpg");

                img1.setImageURI(bl);
                break;
            case R.id.jjs:
                Uri uri2 = Uri.parse("http://mobile.bwstudent.com/images/movie/stills/ws/ws1.jpg");
                GenericDraweeHierarchy gg2 = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setFadeDuration(5000)
                        .build();
                img.setHierarchy(gg2);
                DraweeController jj=  Fresco.newDraweeControllerBuilder()
                        .setUri(uri2)
                        .setTapToRetryEnabled(true)
                        .build();
                img.setController(jj);

                break;
            case R.id.cphc:

                break;
            case R.id.jzdt:
                Uri parse = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535551551658&di=934935e17256ee57ed0416598b78154e&imgtype=0&src=http%3A%2F%2Fs6.sinaimg.cn%2Fmw690%2F0062ywFUgy6Y2pBG8Vn65%26690");
               DraweeController build1 = Fresco.newDraweeControllerBuilder()
                       .setUri(parse)
                       .setAutoPlayAnimations(true)
                        .build();
                img.setController(build1);

                break;
            case R.id.jzjt:
                Uri  uri4 = Uri.parse("http://mobile.bwstudent.com/images/movie/stills/ws/ws1.jpg");
              ControllerListener controllerListener = new BaseControllerListener<ImageInfo>()
              {
                  @Override
                  public void onFinalImageSet(
                          String id,
                          @Nullable ImageInfo imageInfo,
                          @Nullable Animatable anim) {
                      if (imageInfo == null) {
                          return;
                      }
                      QualityInfo qualityInfo = imageInfo.getQualityInfo();
                      FLog.d("Final image received! " +
                                      "Size %d x %d",
                              "Quality level %d, good enough: %s, full quality: %s",
                              imageInfo.getWidth(),
                              imageInfo.getHeight(),
                              qualityInfo.getQuality(),
                              qualityInfo.isOfGoodEnoughQuality(),
                              qualityInfo.isOfFullQuality());
                  }

                  @Override
                  public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                     FLog.d("啦啦啦啦啦","lallallallal");
                  }

                  @Override
                  public void onFailure(String id, Throwable throwable) {
                      FLog.e(getClass(), throwable, "Error loading %s", id);
                  }

                };

                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setControllerListener(controllerListener)
                        .setUri(uri4)
                        // other setters
                        .build();
                img.setController(controller);

                break;
            case R.id.pz:

                break;


        }

    }
}
