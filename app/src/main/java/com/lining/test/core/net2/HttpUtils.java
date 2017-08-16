package com.lining.test.core.net2;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/15 9:47
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class HttpUtils {

    public static <T>void  LoadingFromServer(String url, final Class<T> clazz, final CallBackListener2 listener2) {

        OkHttpUtils.get()
                .url(url)
//                ..addParams("username", "hyman")
//                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {

                    }

                    @Override
                    public void onResponse(String s, int i) {

                        Gson gson=new Gson();
                        T t = gson.fromJson(s, clazz);
                    }
                });
    }
}