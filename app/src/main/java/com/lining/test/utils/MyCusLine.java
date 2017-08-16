package com.lining.test.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/10 9:16
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class MyCusLine extends RecyclerView.ItemDecoration {

    public MyCusLine() {
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(4, 4, 4, 4);
    }
}
