package com.startup.uic;

/**
 * Created by 규열 on 2018-01-29.
 */

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by 규열 on 2018-01-06.
 */

public class F0_S2_Adapter extends BaseMultiItemQuickAdapter<TESTMultipleItem, BaseViewHolder> {

    Context context;
    LayoutInflater inflater;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F0_S2_Adapter(Context context, List<TESTMultipleItem> data) {
        super(data);
        this.context = context;
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s2_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s2_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s2_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT3, R.layout.f0_s2_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT3, R.layout.f0_s2_recyclerview_row);
    }

    @Override
    protected void convert(BaseViewHolder helper, TESTMultipleItem item) {
        switch (helper.getAdapterPosition()) {
            case 0:
                Picasso.with(context).load(url + "image1.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s2_image));
                ((TextView)helper.getView(R.id.f0_s2_name)).setText("무슨무슨 원단 이름");
                break;
            case 1:
                Picasso.with(context).load(url + "image2.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s2_image));
                break;
            case 2:
                Picasso.with(context).load(url + "image3.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s2_image));
                break;
            case 3:
                Picasso.with(context).load(url + "image4.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s2_image));
                break;
            case 4:
                Picasso.with(context).load(url + "image5.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s2_image));
                Log.d("TAG", "TAGGGGGGGEGEGE");
                break;
        }
    }

    public static int dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}