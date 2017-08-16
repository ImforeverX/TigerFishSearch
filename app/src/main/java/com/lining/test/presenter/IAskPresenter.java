package com.lining.test.presenter;

import com.lining.test.base.BasePresenter;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/8 21:25
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public interface IAskPresenter extends BasePresenter {

    void loadData(String sid, String rowNumber, String lastId);

}
