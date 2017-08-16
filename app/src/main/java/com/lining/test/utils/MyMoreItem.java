package com.lining.test.utils;

/**
 * @author lining
 * @version $Rev$
 * @time 2017/8/10 9:05
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes $Des$
 */

public class MyMoreItem {

    /**
     * 0大图
     * 1按钮模块
     * 2子标题
     * 3小图
     */
    public String s;
    public int type;

    public MyMoreItem(String s, int type) {

        this.s = s;
        this.type = type;
    }

    public MyMoreItem(String s) {
        this.s = s;
    }
}
