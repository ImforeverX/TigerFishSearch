package com.lining.test.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lining.test.R;
import com.lining.test.fragment.CarFragment;
import com.lining.test.model.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/13 19:40
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {
    private final Context context;
    private List<ShopBean.OrderDataBean.CartlistBean> list;

    public CarAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_car_content, parent, false);
        return new CarViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(CarViewHolder holder, final int position) {
        if (position > 0) {
            if (list.get(position).getShopId() == list.get(position - 1).getShopId()) {
                holder.carHeader.setVisibility(View.GONE);
            } else {
                holder.carHeader.setVisibility(View.VISIBLE);
            }
        } else {
            holder.carHeader.setVisibility(View.VISIBLE);
        }
        holder.carClothColor.setText("颜色：" + list.get(position).getColor());
        holder.carClothSize.setText("尺寸：" + list.get(position).getSize());
        holder.carClothname.setText(list.get(position).getProductName());
        holder.carShopname.setText(list.get(position).getShopName());
        holder.carClothPrice.setText("¥" + list.get(position).getPrice());
        holder.carClothNum.setText(list.get(position).getCount() + "");
        Glide.with(context).load(list.get(position).getDefaultPic()).into(holder.carClothPic);

        //标记商品是否被选中
        if (list.get(position).isSelect()) {
            holder.carClothselect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.carClothselect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }
        if (list.get(position).isShopSelect()) {
            holder.carShopselect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.carShopselect.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        //商品删除
        holder.carClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (onDeleteListener != null) {
                    onDeleteListener.onDelete(view, position, list.get(position).getId());
                }
                list.remove(position);
                //更新数据源
                CarFragment.setFirstState(list);
                notifyDataSetChanged();
            }
        });
//商品minus
        holder.carClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (list.get(position).getCount() > 1) {
                    int count = list.get(position).getCount() - 1;
                    list.get(position).setCount(count);
                    notifyDataSetChanged();
                    if (onEditListener != null) {
                        onEditListener.onEdit(position, list.get(position).getId(), count);
                    }
                }
            }
        });

        //商品add
        holder.carClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = list.get(position).getCount() + 1;
                list.get(position).setCount(count);
                notifyDataSetChanged();
                if (onEditListener != null) {
                    onEditListener.onEdit(position, list.get(position).getId(), count);
                }
            }
        });
        //商品条目选中与非选中
        holder.carClothselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //标记每一个条目的选中状态
                list.get(position).setSelect(list.get(position).isSelect());
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        //同一家商铺有一个未选中，则商铺按钮不选中
                        if (list.get(position).getShopId() == list.get(position).getShopId() && !list.get(position).isSelect()) {
                            list.get(position).setShopSelect(false);
                        } else {
                            list.get(position).setShopSelect(true);
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });
        //商铺选中与非选中
        holder.carShopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(position).getIsFirst() == 1) {
                    list.get(position).setShopSelect(!list.get(position).isShopSelect());
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getShopId() == list.get(position).getShopId()) {

                            list.get(i).setShopSelect(list.get(i).isShopSelect());
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });

        if (onRefreshViewListener != null) {
            boolean isSelect = false;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isSelect()) {
                    isSelect = false;
                } else {
                    isSelect = true;
                }
            }
            onRefreshViewListener.onRefresh(isSelect, list);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<ShopBean.OrderDataBean.CartlistBean> orderData) {
        if (orderData != null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(orderData);
        notifyDataSetChanged();
    }

    class CarViewHolder extends ViewHolder {
        @BindView(R.id.view)
        View view;
        @BindView(R.id.car_shopselect)
        ImageView carShopselect;
        @BindView(R.id.car_shopname)
        TextView carShopname;
        @BindView(R.id.car_header)
        LinearLayout carHeader;
        @BindView(R.id.car_clothname)
        TextView carClothname;
        @BindView(R.id.car_clothselect)
        ImageView carClothselect;
        @BindView(R.id.car_cloth_pic)
        ImageView carClothPic;
        @BindView(R.id.car_cloth_price)
        TextView carClothPrice;
        @BindView(R.id.car_cloth_color)
        TextView carClothColor;
        @BindView(R.id.car_cloth_size)
        TextView carClothSize;
        @BindView(R.id.car_cloth_minus)
        ImageView carClothMinus;
        @BindView(R.id.car_cloth_num)
        TextView carClothNum;
        @BindView(R.id.car_cloth_add)
        ImageView carClothAdd;
        @BindView(R.id.car_cloth_delete)
        ImageView carClothDelete;

        CarViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //商品 增加 减少
    private OnEditListener onEditListener;

    public interface OnEditListener {

        void onEdit(int position, int carId, int count);
    }

    public void setOnEditListener(OnEditListener onEditListener) {
        this.onEditListener = onEditListener;
    }

    //商品选中状态是否发生改变
    private OnRefreshViewListener onRefreshViewListener;

    public interface OnRefreshViewListener {
        void onRefresh(boolean isSelect, List<ShopBean.OrderDataBean.CartlistBean> list);
    }

    public void setOnRefreshView(OnRefreshViewListener onRefreshViewListener) {
        this.onRefreshViewListener = onRefreshViewListener;
    }

    //商品每一个条目
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //删除一个条目
    private OnDeleteListener onDeleteListener;

    public interface OnDeleteListener {
        void onDelete(View view, int postion, int carId);
    }

    public void setOnDeleteListener(OnDeleteListener onDeleteListener) {
        this.onDeleteListener = onDeleteListener;
    }
}
