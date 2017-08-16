package com.lining.test.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 20:11
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class CustomVideoView extends VideoView {
    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);//
        //这中间的一大段代码就是计算视频比例，计算各种大小，返回一个固定的比例再赋值给 width height。
        //所以无论你给videoview 设置多少的长宽，出来之后也不是你想要的大小比例
        setMeasuredDimension(width, height);
    }
}
