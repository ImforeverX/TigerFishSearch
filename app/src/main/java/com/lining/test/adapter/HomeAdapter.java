package com.lining.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lining.test.R;
import com.lining.test.utils.MyMoreItem;

import java.util.List;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/9 16:58
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private List<String> dataList;
    private final List<MyMoreItem> typeList;

    public HomeAdapter(Context context, List<MyMoreItem> typeList) {
        this.context = context;
        this.typeList = typeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new MyHomeViewHolder(view);
        switch (viewType) {
            case 0:
                return new HugeViewHolder(getView(parent, R.layout.activity_home_huge));
            case 1:
                return new FourViewHolder(getView(parent, R.layout.activity_home_four));
            case 2:
                return new OneViewHolder(getView(parent, R.layout.activity_home_one));
            default:
                return new TwoViewHolder(getView(parent, R.layout.activity_home_two));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String s = typeList.get(position).s;
        if (holder instanceof HugeViewHolder) {
            HugeViewHolder huge = (HugeViewHolder) holder;
        } else if (holder instanceof FourViewHolder) {
            FourViewHolder four = (FourViewHolder) holder;
        } else if (holder instanceof OneViewHolder) {
            OneViewHolder one = (OneViewHolder) holder;
            one.tv.setText(s);
        } else{
            TwoViewHolder two = (TwoViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return typeList == null ? 0 : typeList.size();
    }

    @Override
    public int getItemViewType(int position) {
        MyMoreItem item = typeList.get(position);
        return item.type;
    }

    //获取布局加载器
    public View getView(ViewGroup parent, int res) {
        View view = LayoutInflater.from(context).inflate(res, parent, false);
        return view;
    }

    //获取单个条目对象
    public MyMoreItem getItem(int position) {
        return typeList.get(position);
    }

    static class HugeViewHolder extends RecyclerView.ViewHolder {

        public HugeViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class FourViewHolder extends RecyclerView.ViewHolder {
        public FourViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class OneViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public OneViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);

        }
    }

    static class TwoViewHolder extends RecyclerView.ViewHolder {
        public TwoViewHolder(View itemView) {
            super(itemView);
        }
    }
}
