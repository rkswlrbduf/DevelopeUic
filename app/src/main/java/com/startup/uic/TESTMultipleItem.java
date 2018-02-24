package com.startup.uic;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by 규열 on 2018-01-29.
 */

public class TESTMultipleItem implements MultiItemEntity {
    public static final int WEIGHT2 = 2;
    public static final int WEIGHT3 = 3;
    private int itemType;

    public TESTMultipleItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}