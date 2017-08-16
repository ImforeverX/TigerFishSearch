package com.lining.test.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lining.test.R;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 21:52
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class BottomLayout extends LinearLayout {

    private View view;

    public BottomLayout(Context context) {
        super(context);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //View view =  LayoutInflater.from(context).inflate(R.layout.tab_layout,null,false);
//        View view = View.inflate(context, R.layout.tab_layout,null);
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, this);
//        addView(view);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.tab_radiogroup);
        RadioButton radiobutton_home = (RadioButton) view.findViewById(R.id.radiobutton_home);
        RadioButton radiobutton_category = (RadioButton) view.findViewById(R.id.radiobutton_category);
        RadioButton radiobutton_car = (RadioButton) view.findViewById(R.id.radiobutton_car);
        RadioButton radiobutton_mine = (RadioButton) view.findViewById(R.id.radiobutton_mine);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch (checkedId) {

                    case R.id.radiobutton_home:

                        setListener(0);
                        break;
                    case R.id.radiobutton_category:
                        setListener(1);
                        break;
                    case R.id.radiobutton_car:
                        setListener(2);
                        break;
                    case R.id.radiobutton_mine:
                        setListener(3);
                        break;
                }
            }
        });

    }

    private void setListener(int index) {
        if (listener != null) {
            listener.onListener(index);
        }
    }

    private OnSelectedListener listener;

    public interface OnSelectedListener {
        void onListener(int Position);
    }

    public void setOnSelectedListener(OnSelectedListener listener) {
        this.listener = listener;
    }

}
