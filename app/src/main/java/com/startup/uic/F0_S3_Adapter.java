package com.startup.uic;

/**
 * Created by 규열 on 2018-01-29.
 */

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.squareup.picasso.Picasso;

import java.util.List;
import com.chad.library.adapter.base.BaseViewHolder;


/**
 * Created by 규열 on 2018-01-06.
 */

public class F0_S3_Adapter extends BaseMultiItemQuickAdapter<TESTMultipleItem, BaseViewHolder> {

    Context context;
    LayoutInflater inflater;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F0_S3_Adapter(Context context, List<TESTMultipleItem> data) {
        super(data);
        this.context = context;
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s3_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s3_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT2, R.layout.f0_s3_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT3, R.layout.f0_s3_recyclerview_row);
        addItemType(TESTMultipleItem.WEIGHT3, R.layout.f0_s3_recyclerview_row);
    }

    @Override
    protected void convert(BaseViewHolder helper, TESTMultipleItem item) {
        switch (helper.getAdapterPosition()) {
            case 0:
                Picasso.with(context).load(url + "image6.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s3_image));
                ((TextView)helper.getView(R.id.f0_s3_name)).setText("무슨무슨 원단 이름");
                break;
            case 1:
                Picasso.with(context).load(url + "image7.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s3_image));
                break;
            case 2:
                Picasso.with(context).load(url + "image8.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s3_image));
                break;
            case 3:
                Picasso.with(context).load(url + "image9.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s3_image));
                break;
            case 4:
                Picasso.with(context).load(url + "image10.png").centerCrop().resize(dipToPixels(context, 96),dipToPixels(context, 96)).into((ImageView)helper.getView(R.id.f0_s3_image));
                Log.d("TAG", "TAGGGGGGGEGEGE");
                break;
        }
    }

    public static int dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}