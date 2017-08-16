package com.lining.test.view;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 21:33
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public interface IAskPlusView<T> {

    void showOrHideLoading(boolean flag);

    void refreshView(T t);

    void showOrHideError(boolean flag);

}
