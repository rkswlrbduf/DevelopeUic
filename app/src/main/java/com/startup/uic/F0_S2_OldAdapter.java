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

import com.squareup.picasso.Picasso;

/**
 * Created by 규열 on 2018-01-06.
 */

public class F0_S2_OldAdapter extends RecyclerView.Adapter<F0_S2_OldAdapter.MyViewHolder> {

    private static final int TYPE_LEFT_THIRD = 0;
    private static final int TYPE_MIDDLE_THIRD = 1;
    private static final int TYPE_RIGHT_THIRD = 2;
    private static final int TYPE_LEFT_HALF = 3;
    private static final int TYPE_RIGHT_HALF = 4;

    Context context;
    LayoutInflater inflater;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F0_S2_OldAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_LEFT_THIRD;
            case 1:
                return TYPE_MIDDLE_THIRD;
            case 2:
                return TYPE_RIGHT_THIRD;
        }
        int mode = position % 2;
        switch (mode) {
            case 0:
                return TYPE_RIGHT_HALF;
            case 1:
                return TYPE_LEFT_HALF;
        }
        return -1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = inflater.inflate(R.layout.f0_s2_recyclerview_row, parent, false);
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                final int type = viewType;
                final ViewGroup.LayoutParams lp = view.getLayoutParams();
                if (lp instanceof GridLayoutManager.LayoutParams) {
                    GridLayoutManager.LayoutParams sglp = (GridLayoutManager.LayoutParams) lp;
                    switch (type) {
                        case TYPE_LEFT_THIRD:
                        case TYPE_MIDDLE_THIRD:
                        case TYPE_RIGHT_THIRD:
                            sglp.width = parent.getWidth() / 3;
                            sglp.height = sglp.width;
                            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(sglp.width, sglp.width);
                            ((ImageView) view.findViewById(R.id.f0_s2_image)).setLayoutParams(layoutParams1);
                            sglp.height += ((LinearLayout)view.findViewById(R.id.f0_s2_container)).getHeight() + dipToPixels(context, 6);
                            view.setLayoutParams(sglp);
                            break;
                        case TYPE_LEFT_HALF:
                        case TYPE_RIGHT_HALF:
                            sglp.width = parent.getWidth() / 2;
                            sglp.height = sglp.width;
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(sglp.width, sglp.width);
                            ((ImageView) view.findViewById(R.id.f0_s2_image)).setLayoutParams(layoutParams2);
                            sglp.height += ((LinearLayout)view.findViewById(R.id.f0_s2_container)).getHeight() + dipToPixels(context, 6);
                            view.setLayoutParams(sglp);
                            break;
                    }
                    view.setPadding(0, 0, 0, 0);

                }
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                Picasso.with(context).load(url + "f1_section2_1.png").into(holder.image);
                holder.name.setText("무슨무슨 원단 이름");
                break;
            case 1:
                Picasso.with(context).load(url + "f1_section2_2.png").into(holder.image);
                break;
            case 2:
                Picasso.with(context).load(url + "f1_section2_3.png").into(holder.image);
                break;
            case 3:
                Picasso.with(context).load(url + "f1_section2_4.png").into(holder.image);
                break;
            case 4:
                Picasso.with(context).load(url + "f1_section2_5.png").into(holder.image);
                Log.d("TAG", "TAGGGGGGGEGEGE");
                break;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView current_price;
        TextView before_price;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.f0_s2_image);
            name = (TextView) itemView.findViewById(R.id.f0_s2_name);
            current_price = (TextView) itemView.findViewById(R.id.f0_s2_current_price);
            before_price = (TextView) itemView.findViewById(R.id.f0_s2_before_price);
        }
    }
}