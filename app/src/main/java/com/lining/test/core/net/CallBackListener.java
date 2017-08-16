package com.lining.test.core.net;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 19:54
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public interface CallBackListener<T> {

    void onNetSuccess(T t);

    void onNetFailed(T t);

    void onNetStart();
}
