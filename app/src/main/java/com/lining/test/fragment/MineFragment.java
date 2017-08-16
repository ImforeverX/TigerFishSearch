package com.lining.test.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lining.test.R;
import com.lining.test.base.Basefragment;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/13 21:32
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class MineFragment extends Basefragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected View initSelfView(ViewGroup container) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.activity_mine,container,false);
    }
}
