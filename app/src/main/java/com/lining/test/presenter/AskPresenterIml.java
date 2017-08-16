package com.lining.test.presenter;

import android.annotation.SuppressLint;

import com.lining.test.core.net.CallBackListener;
import com.lining.test.model.bean.Bean;
import com.lining.test.model.HomeServer;
import com.lining.test.view.IAskPlusView;

import retrofit2.Call;

import static java.nio.file.Paths.get;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 21:27
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class AskPresenterIml implements IAskPresenter {
    private IAskPlusView iAskPlusView;
    private final String sid;
    private final String rowNember;
    private final String lastId;
    private Call<String> call;

    public AskPresenterIml(IAskPlusView iAskPlusView, String sid, String rowNumber, String lastId) {

        this.iAskPlusView = iAskPlusView;
        this.sid = sid;
        this.rowNember = rowNumber;
        this.lastId = lastId;
    }

    @SuppressLint("NewApi")
    @Override
    public void start() {
        getData(sid, rowNember, lastId);

    }

    private void getData(String sid, String rowNember, String lastId) {

        call = HomeServer.getSingle().getAskResponse(sid, rowNember, lastId, new CallBackListener<Bean>() {
            @Override
            public void onNetSuccess(Bean bean) {
                iAskPlusView.showOrHideLoading(true);
                if (iAskPlusView != null) {

                    if (bean != null) {
                        iAskPlusView.refreshView(bean);
                    } else {

                        iAskPlusView.showOrHideError(false);
                    }
                }
            }

            @Override
            public void onNetFailed(Bean bean) {
                iAskPlusView.showOrHideLoading(false);
            }

            @Override
            public void onNetStart() {
                iAskPlusView.showOrHideLoading(false);
            }
        });
    }

    //销毁
    @Override
    public void detachView() {

        if (iAskPlusView != null) {
            iAskPlusView = null;
        }
        if (call != null && call.isCanceled()) {

            call.isCanceled();
            call = null;
        }
    }

    //个性化设置
    @Override
    public void loadData(String sid, String rowNumber, String lastId) {

    }
}
