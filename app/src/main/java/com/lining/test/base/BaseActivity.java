package com.lining.test.base;

import android.app.Activity;
import android.view.View;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/11 9:57
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public abstract class BaseActivity extends Activity {
    @Override
    public void setContentView(View view) {
        super.setContentView(getLayoutId());

        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
