package com.lining.test.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.lining.test.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 16:07
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class WelcomeActivity extends Activity {

    private VideoView customVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigationactiivty);
        customVideoView = (VideoView) findViewById(R.id.customVideoView);
        //设置viewView的播放路径
        //String uri = "file:///android_asset/xiaopohai.3gp";
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.xiaopohai;
        customVideoView.setVideoPath(uri);
        //
        MediaController mc = new MediaController(this);
        mc.setVisibility(View.INVISIBLE);
        //设置媒体控制器
        customVideoView.setMediaController(mc);
        //绑定视图
        mc.setAnchorView(customVideoView);
        customVideoView.start();

    }
}
