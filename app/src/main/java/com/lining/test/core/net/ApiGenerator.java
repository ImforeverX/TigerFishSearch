package com.lining.test.core.net;

import com.google.gson.Gson;
import com.lining.test.Constans_;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 19:02
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class ApiGenerator {

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constans_.BASE.BASEURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    public static BaseService getNetServer() {

        return retrofit.create(BaseService.class);
    }
}
