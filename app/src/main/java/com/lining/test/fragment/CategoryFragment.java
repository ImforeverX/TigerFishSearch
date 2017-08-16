package com.lining.test.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lining.test.R;
import com.lining.test.adapter.FragmentVpAdapter;
import com.lining.test.base.Basefragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/13 21:32
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class CategoryFragment extends Basefragment {

    private ViewPager vp;
    private TabLayout tab;
    private List<String> tablist = new ArrayList<>();
    private List<Fragment> views = new ArrayList<>();
    private FragmentVpAdapter fragmentVpAdapter;
    private View view;

    @Override
    protected void initData() {
        initViews();
        initTabStr();
        tab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < 3; i++) {
            tab.addTab(tab.newTab().setText(tablist.get(i)));
        }
        fragmentVpAdapter = new FragmentVpAdapter(getActivity().getSupportFragmentManager(), views, tablist);
        vp.setAdapter(fragmentVpAdapter);
//        将tablelayout和ViewPager关联起来
        tab.setupWithViewPager(vp);
        tab.setTabsFromPagerAdapter(fragmentVpAdapter);
    }

    @Override
    protected void initView(View view) {
        tab = ((TabLayout) view.findViewById(R.id.tabLayout));
        vp = ((ViewPager)  view.findViewById(R.id.viewPager));
    }

    @Override
    protected View initSelfView(ViewGroup container) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.activity_category, container, false);
    }

    /**
     * 同样为了简单，标题栏的内容就这么附值了。
     */
    private void initTabStr() {
        tablist.clear();
        tablist.add("全球购");
        tablist.add("奢侈品");
        tablist.add("服装城");
    }

    /**
     * 初始化Viewpager的每个页面内容，这里为了简单，就直接new的视图
     * 如果想要不同布局的内容，就按ViewPager的使用方式就行了。
     */
    private void initViews() {
        views.clear();
        views.add(new CategoryFragment_globe());
        views.add(new CategoryFragment_luxury());
        views.add(new CategoryFragment_pnicc());
    }
}
