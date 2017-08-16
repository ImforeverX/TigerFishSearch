package com.lining.test.model;

import com.lining.test.Constans_;
import com.lining.test.core.net.ApiGenerator;
import com.lining.test.core.net.BaseService;

import retrofit2.Call;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 19:55
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class ApiHome {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static volatile ApiHome single = null;
    private BaseService baseService;

    /* 私有构造方法，防止被实例化 */
    private ApiHome() {
        baseService = ApiGenerator.getNetServer();
    }

    public static ApiHome getSingle() {
        if (single == null) {
            synchronized (ApiHome.class) {
                if (single == null) {
                    single = new ApiHome();
                }
            }
        }
        return single;
    }

    public Call<String> getAskFromServer(String sid, String rowNumber, String lastId) {
        if (baseService == null) {

            baseService = ApiGenerator.getNetServer();
        }
        return baseService.baseGetRequest(getAskUrl(sid, rowNumber, lastId));
    }

    private String getAskUrl(String sid, String rowNumber, String lastId) {
        StringBuffer sb = new StringBuffer();
        sb.append(Constans_.BASE.BASEURL).append("getAskBarPlusList?sid=").append(sid).append("&rowNumber=").append(rowNumber).append("&lastId=").append(lastId);
        return sb.toString();
    }
}
