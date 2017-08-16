package com.lining.test.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

import com.lining.test.R;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/12 21:04
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

@SuppressLint("AppCompatCustomView")
public class CustomNavigationButton extends Button {

    private final Bitmap bitmap;

    public CustomNavigationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        int car = R.drawable.sample;
        bitmap = BitmapFactory.decodeResource(getResources(), car);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 图片顶部居中显示
        int x = (this.getMeasuredWidth() - bitmap.getWidth())/2;
        int y = 0;
        canvas.drawBitmap(bitmap, x, y, null);
        // 坐标需要转换，因为默认情况下Button中的文字居中显示
        // 这里需要让文字在底部显示
        canvas.translate(0,(this.getMeasuredHeight()/2) - (int) this.getTextSize());
    }
}
