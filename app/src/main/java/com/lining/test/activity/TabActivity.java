package com.lining.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.lining.test.R;
import com.lining.test.custom.BottomLayout;
import com.lining.test.fragment.CarFragment;
import com.lining.test.fragment.CategoryFragment;
import com.lining.test.fragment.HomeFragment;
import com.lining.test.fragment.MineFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/13 15:00
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */




public class TabActivity extends FragmentActivity implements BottomLayout.OnSelectedListener {

    private FragmentManager fragmentManager;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity);

        fragmentManager = getSupportFragmentManager();
        createFragment(savedInstanceState);
        BottomLayout bottomLayout = (BottomLayout) findViewById(R.id.bottomlayout);
        bottomLayout.setOnSelectedListener(this);
        switchFragment(0);
    }

    private void switchFragment(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!fragments.get(index).isAdded()) {
            transaction.add(R.id.container, fragments.get(index), fragments.get(index).getClass().getSimpleName());
        }
        for (int i = 0; i < fragments.size(); i++) {

            if (i == index) {
                transaction.show(fragments.get(index));
            } else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    private void createFragment(Bundle savedInstanceState) {
        HomeFragment homeFragment = (HomeFragment) fragmentManager.findFragmentByTag("HomeFragment");
        CategoryFragment categoryFragment = (CategoryFragment) fragmentManager.findFragmentByTag("CategoryFragment");
        CarFragment carFragment = (CarFragment) fragmentManager.findFragmentByTag("CarFragment");
        MineFragment mineFragment = (MineFragment) fragmentManager.findFragmentByTag("MineFragment");

        if (homeFragment == null) {
            homeFragment = new HomeFragment();
        }
        if (categoryFragment == null) {
            categoryFragment = new CategoryFragment();
        }
        if (carFragment == null) {
            carFragment = new CarFragment();
        }
        if (mineFragment == null) {
            mineFragment = new MineFragment();
        }
        fragments.add(homeFragment);
        fragments.add(categoryFragment);
        fragments.add(carFragment);
        fragments.add(mineFragment);
    }

    @Override
    public void onListener(int index) {
        switchFragment(index);
    }
}
