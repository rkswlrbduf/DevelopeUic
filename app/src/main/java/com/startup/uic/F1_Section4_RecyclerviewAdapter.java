package com.startup.uic;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by 규열 on 2018-01-06.
 */

public class F1_Section4_RecyclerviewAdapter extends RecyclerView.Adapter<F1_Section4_RecyclerviewAdapter.MyViewHolder> {

    private static final int TYPE_LEFT_THIRD = 0;
    private static final int TYPE_MIDDLE_THIRD = 1;
    private static final int TYPE_RIGHT_THIRD = 2;
    private static final int TYPE_LEFT_HALF = 3;
    private static final int TYPE_RIGHT_HALF = 4;

    Context context;
    LayoutInflater inflater;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F1_Section4_RecyclerviewAdapter(Context context, LayoutInflater inflater) {
        this.context = context;
        this.inflater = inflater;
    }

/*    @Override
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
        return -1;    }*/

    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = inflater.inflate(R.layout.f1_section4_recyclerview_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.background.setBackgroundColor(Color.parseColor("#a0c8ff"));
                Picasso.with(context).load(url+"f1_section4_1.png").fit().centerCrop().into(holder.image);
                holder.main_name.setText("유익 페북 페이지 오-픈");
                holder.sub_name.setText("페이지 팔로우하고 개이득보자!");
                break;
            case 1:
                holder.background.setBackgroundColor(Color.parseColor("#ffd536"));
                Picasso.with(context).load(url+"f1_section4_2.png").fit().centerCrop().into(holder.image);
                holder.main_name.setText("연말 결산템");
                holder.sub_name.setText("유익의 1년, Best Of Best Items");
                break;
            case 2:
                holder.background.setBackgroundColor(Color.parseColor("#d7d5e1"));
                Picasso.with(context).load(url+"f1_section4_3.png").fit().centerCrop().into(holder.image);
                holder.main_name.setText("역시즌 할인 쟁여놓기");
                holder.sub_name.setText("역시즌으로 원단 겟하기!");
                break;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView main_name;
        TextView sub_name;
        RelativeLayout background;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.section4_image);
            sub_name = (TextView)itemView.findViewById(R.id.section4_subname);
            main_name = (TextView)itemView.findViewById(R.id.section4_mainname);
            background = (RelativeLayout)itemView.findViewById(R.id.f1_section4_container);
        }
    }

}
