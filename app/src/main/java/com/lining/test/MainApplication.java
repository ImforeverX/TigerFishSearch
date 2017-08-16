package com.lining.test;

import android.app.Application;
import android.os.StrictMode;

import com.lining.test.utils.CrashHandler;
import com.squareup.leakcanary.LeakCanary;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //闪退日志
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        //enabledStrictMode();

        //监测内存泄漏
        LeakCanary.install(this);
        // Normal app init code...
        //科大讯飞语音识别集成5969e1da
        //SpeechUtility.createUtility(this, SpeechConstant.APPID +"=5969e1da");

        //初始化用封装好的okh
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                //other配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}
