package com.lining.test.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lining.test.R;
import com.lining.test.adapter.HomeAdapter;
import com.lining.test.base.Basefragment;
import com.lining.test.utils.MyMoreItem;
import com.lining.test.utils.MyCusLine;
import com.lining.test.model.bean.Bean;
import com.lining.test.presenter.AskPresenterIml;
import com.lining.test.view.IAskPlusView;

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

public class HomeFragment extends Basefragment implements IAskPlusView<Bean> {

    private AskPresenterIml presenter;
    private TextView textView;
    private RecyclerView xRecyclerView;
    private List<String> dataList = new ArrayList<>();
    private HomeAdapter adapter;
    private List<MyMoreItem> typeList = new ArrayList<>();

    @Override
    protected void initData() {
        //进行网络请求
        presenter = new AskPresenterIml(this, "xkycs", "0", "0");
        presenter.start();
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 8);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                MyMoreItem item = adapter.getItem(position);
                switch (item.type) {
                    case 0:
                        return 8;
                    case 1:
                        return 2;
                    case 2:
                        return 8;
                    default:
                        return 4;
                }
            }
        });
//      manager.setOrientation(GridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        //设置分割线
        xRecyclerView.addItemDecoration(new MyCusLine());
        initSource();
        adapter = new HomeAdapter(getActivity(), typeList);
        xRecyclerView.setAdapter(adapter);
//        xRecyclerView.setArrowImageView(R.drawable.title);
//        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//            @Override
//            public void onRefresh() {
//                xRecyclerView.refreshComplete();
//            }
//
//            @Override
//            public void onLoadMore() {
//                typeList.add(new MyItem("ssssssssssssssssssssssssssssssssssssss"));
//                adapter.notifyDataSetChanged();
//                xRecyclerView.loadMoreComplete();
//            }
//        });
    }

    private void initSource() {
        for (int i = 0; i < 100; i++) {

            if (i == 0) {
                typeList.add(new MyMoreItem("一声" + i, 0));
            } else if (i > 0 && i < 5) {
                typeList.add(new MyMoreItem("一外声" + i, 1));
            } else if (i == 5) {
                typeList.add(new MyMoreItem("一声声声" + i, 2));
            } else {
                typeList.add(new MyMoreItem("一声声外声" + i, 3));
            }
        }
    }

    @Override
    protected void initView(View view) {
        xRecyclerView = (RecyclerView) view.findViewById(R.id.xRecyclerView);
        textView = (TextView) view.findViewById(R.id.textView);
    }

    @Override
    protected View initSelfView(ViewGroup container) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.activity_home, container, false);
    }

    @Override
    public void showOrHideLoading(boolean flag) {

    }

    @Override
    public void refreshView(Bean bean) {

        textView.setText(bean.list.get(1).authorName);

    }

    @Override
    public void showOrHideError(boolean flag) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
