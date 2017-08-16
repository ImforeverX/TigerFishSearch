package com.lining.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lining.test.R;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 9:47
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class CategoryFragment_globe extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_category_globe, container, false);
    }
   /*  @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected View initSelfView(ViewGroup parent) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.activity_category_content,parent,false);
    }*/
}
