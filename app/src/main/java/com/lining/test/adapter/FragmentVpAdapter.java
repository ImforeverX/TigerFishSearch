package com.lining.test.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lining.test.R;
import com.lining.test.fragment.CategoryFragment;

import java.util.List;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/11 21:32
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */
public class FragmentVpAdapter extends FragmentPagerAdapter {
    //    这个是viewpager的填充视图
    //    这个是table导航条里面的内容填充
    private List<String> tablist;
    private List<Fragment> views;

    public FragmentVpAdapter(FragmentManager fm, List<Fragment> views, List<String> tablist) {
        super(fm);
        this.views = views;
        this.tablist = tablist;
    }

    @Override
    public int getCount() {
        return tablist == null ? 0 : tablist.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }
}