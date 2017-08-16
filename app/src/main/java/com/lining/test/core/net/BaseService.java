package com.lining.test.core.net;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 19:10
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public interface BaseService {

    @GET
    public Call<String> baseGetRequest(@Url String url);

    @POST
    @FormUrlEncoded
    public Call<String> basePosrRequest(@Url String usrl);
}
