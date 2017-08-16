package com.lining.test.model;

import com.lining.test.core.net.CallBackListener;
import com.lining.test.model.bean.Bean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 20:29
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class HomeServer {
    private static volatile HomeServer single = null;

    private HomeServer() {
    }

    public static HomeServer getSingle() {
        if (single == null) {
            synchronized (HomeServer.class) {
                if (single == null) {
                    single = new HomeServer();
                }
            }
        }
        return single;
    }

    public Call<String> getAskResponse(String sid, String rowNumber, final String lasrId, final CallBackListener listener) {

        listener.onNetStart();

        Call<String> call = ApiHome.getSingle().getAskFromServer(sid, rowNumber, lasrId);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response != null && response.isSuccessful() && response.body() != null && response.body().length() > 0) {
                    Bean bean = Bean.objectFromData(response.body().toString());
                    listener.onNetSuccess(bean);
                } else {
                    listener.onNetFailed("");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                listener.onNetFailed("");
            }
        });
        return call;
    }

}
