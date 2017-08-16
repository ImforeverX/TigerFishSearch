package com.lining.test.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lining.test.R;
import com.lining.test.adapter.CarAdapter;
import com.lining.test.base.Basefragment;
import com.lining.test.model.bean.ShopBean;
import com.lining.test.utils.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/13 21:32
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class CarFragment extends Basefragment {

    @BindView(R.id.car_recyclerview)
    RecyclerView carRecyclerview;
    @BindView(R.id.car_allselect)
    TextView carAllselect;
    @BindView(R.id.car_totalprice)
    TextView carTotalprice;
    @BindView(R.id.car_totalnum)
    TextView carTotalnum;
    @BindView(R.id.car_submit)
    TextView carSubmit;
    @BindView(R.id.car_pay_linear)
    LinearLayout carPayLinear;
    Unbinder unbinder;

    private List<ShopBean.OrderDataBean.CartlistBean> list = new ArrayList<>();
    private List<ShopBean.OrderDataBean.CartlistBean> firstState;

    @Override
    protected void initData() {
        carRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        CarAdapter adapter = new CarAdapter(getActivity());
        carRecyclerview.setAdapter(adapter);
        //获取数据
        try {
            InputStream inputStream = getActivity().getAssets().open("shop.json");
            String json = StringUtils.convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean bean = gson.fromJson(json, ShopBean.class);
            for (int i = 0; i < bean.getOrderData().size(); i++) {
                int length = bean.getOrderData().get(i).getCartlist().size();
                for (int j = 0; j < length; j++) {
                    list.add(bean.getOrderData().get(i).getCartlist().get(j));
                }
            }
            setFirstState(list);
            adapter.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected View initSelfView(ViewGroup container) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.activity_car, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    public static void setFirstState(List<ShopBean.OrderDataBean.CartlistBean> firstState) {

        /**
         * 标记第一条数据，isFirst=1显示，否则隐藏
         *
         * @param orderData
         */if (firstState.size() > 0) {
            firstState.get(0).setIsFirst(1);
            for (int i = 1; i < firstState.size(); i++) {

                if (firstState.get(i).getShopId() == firstState.get(i - 1).getShopId()) {
                    firstState.get(i).setIsFirst(2);
                } else {
                    firstState.get(i).setIsFirst(1);
                }
            }
        }
    }
}
