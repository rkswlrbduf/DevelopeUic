package com.startup.uic;

/**
 * Created by 규열 on 2018-01-05.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class F0_S1_Adapter extends RecyclerView.Adapter<F0_S1_Adapter.ViewHolder> {

    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";
    Context context;

    public F0_S1_Adapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.row1_num.setText("1");
        holder.row2_num.setText("2");
        holder.row3_num.setText("3");
        holder.row4_num.setText("4");
        holder.row5_num.setText("5");
        switch (position) {
            case 0:
                holder.row1_name.setText("신상품 카테고리 상품 1");
                holder.row2_name.setText("신상품 카테고리 상품 2");
                holder.row3_name.setText("신상품 카테고리 상품 3");
                holder.row4_name.setText("신상품 카테고리 상품 4");
                holder.row5_name.setText("신상품 카테고리 상품 5");
                Picasso.with(context).load(url + "image1.png").into(holder.row1_image);
                Picasso.with(context).load(url + "image2.png").into(holder.row2_image);
                Picasso.with(context).load(url + "image3.png").into(holder.row3_image);
                Picasso.with(context).load(url + "image4.png").into(holder.row4_image);
                Picasso.with(context).load(url + "image5.png").into(holder.row5_image);
                holder.more.setText("신상품 더 보기");
                break;
            case 1:
                holder.row1_name.setText("Best100 카테고리 상품 1");
                holder.row2_name.setText("Best100 카테고리 상품 2");
                holder.row3_name.setText("Best100 카테고리 상품 3");
                holder.row4_name.setText("Best100 카테고리 상품 4");
                holder.row5_name.setText("Best100 카테고리 상품 5");
                Picasso.with(context).load(url + "image1.png").into(holder.row1_image);
                Picasso.with(context).load(url + "image2.png").into(holder.row2_image);
                Picasso.with(context).load(url + "image3.png").into(holder.row3_image);
                Picasso.with(context).load(url + "image4.png").into(holder.row4_image);
                Picasso.with(context).load(url + "image5.png").into(holder.row5_image);
                holder.more.setText("Best100 더 보기");
                break;
            case 2:
                holder.row1_name.setText("땡처리 카테고리 상품 1");
                holder.row2_name.setText("땡처리 카테고리 상품 2");
                holder.row3_name.setText("땡처리 카테고리 상품 3");
                holder.row4_name.setText("땡처리 카테고리 상품 4");
                holder.row5_name.setText("땡처리 카테고리 상품 5");
                Picasso.with(context).load(url + "image1.png").into(holder.row1_image);
                Picasso.with(context).load(url + "image2.png").into(holder.row2_image);
                Picasso.with(context).load(url + "image3.png").into(holder.row3_image);
                Picasso.with(context).load(url + "image4.png").into(holder.row4_image);
                Picasso.with(context).load(url + "image5.png").into(holder.row5_image);
                holder.more.setText("땡처리 더 보기");
                break;
            case 3:
                holder.row1_name.setText("패키지 카테고리 상품 1");
                holder.row2_name.setText("패키지 카테고리 상품 2");
                holder.row3_name.setText("패키지 카테고리 상품 3");
                holder.row4_name.setText("패키지 카테고리 상품 4");
                holder.row5_name.setText("패키지 카테고리 상품 5");
                Picasso.with(context).load(url + "image1.png").into(holder.row1_image);
                Picasso.with(context).load(url + "image2.png").into(holder.row2_image);
                Picasso.with(context).load(url + "image3.png").into(holder.row3_image);
                Picasso.with(context).load(url + "image4.png").into(holder.row4_image);
                Picasso.with(context).load(url + "image5.png").into(holder.row5_image);
                holder.more.setText("패키지 더 보기");
                break;
            case 4:
                holder.row1_name.setText("이벤트 카테고리 상품 1");
                holder.row2_name.setText("이벤트 카테고리 상품 2");
                holder.row3_name.setText("이벤트 카테고리 상품 3");
                holder.row4_name.setText("이벤트 카테고리 상품 4");
                holder.row5_name.setText("이벤트 카테고리 상품 5");
                Picasso.with(context).load(url + "image1.png").into(holder.row1_image);
                Picasso.with(context).load(url + "image2.png").into(holder.row2_image);
                Picasso.with(context).load(url + "image3.png").into(holder.row3_image);
                Picasso.with(context).load(url + "image4.png").into(holder.row4_image);
                Picasso.with(context).load(url + "image5.png").into(holder.row5_image);
                holder.more.setText("이벤트 더 보기");
                break;
        }

        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        ((MainActivity) context).viewPager.setCurrentItem(1);
                        break;
                    case 1:
                        ((MainActivity) context).viewPager.setCurrentItem(2);
                        break;
                    case 2:
                        ((MainActivity) context).viewPager.setCurrentItem(3);
                        break;
                    case 3:
                        ((MainActivity) context).viewPager.setCurrentItem(4);
                        break;
                    case 4:
                        ((MainActivity) context).viewPager.setCurrentItem(5);
                        break;
                }
                Toast.makeText(context, "TOAST", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.f0_s1_viewpager, parent, false);
        ImageView imageView = v.findViewById(R.id.f0_s1_rankingitem_image);
        int width = context.getResources().getDisplayMetrics().widthPixels - (int) dipToPixels(context, 45f);
        int imageSize = (int)(width*0.12f);
        LinearLayout layout1 = (LinearLayout)v.findViewById(R.id.f0_s1_row1_container);
        LinearLayout layout2 = (LinearLayout)v.findViewById(R.id.f0_s1_row2_container);
        LinearLayout layout3 = (LinearLayout)v.findViewById(R.id.f0_s1_row3_container);
        LinearLayout layout4 = (LinearLayout)v.findViewById(R.id.f0_s1_row4_container);
        LinearLayout layout5 = (LinearLayout)v.findViewById(R.id.f0_s1_row5_container);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, imageSize);
        params1.setMargins(0,0,0,(int)dipToPixels(context,10f));
        layout1.setLayoutParams(params1);
        layout2.setLayoutParams(params1);
        layout3.setLayoutParams(params1);
        layout4.setLayoutParams(params1);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, imageSize);
        params2.setMargins(0,0,0,0);
        layout5.setLayoutParams(params2);
        imageSize = (int)(width*0.127f);
        TextView textView = (TextView)v.findViewById(R.id.f0_s1_more);
        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, imageSize));
        CardView.LayoutParams params = new CardView.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView more;
        TextView row1_num;
        TextView row2_num;
        TextView row3_num;
        TextView row4_num;
        TextView row5_num;
        CircleImageView row1_image;
        CircleImageView row2_image;
        CircleImageView row3_image;
        CircleImageView row4_image;
        CircleImageView row5_image;
        TextView row1_name;
        TextView row2_name;
        TextView row3_name;
        TextView row4_name;
        TextView row5_name;
        TextView row1_price;
        TextView row2_price;
        TextView row3_price;
        TextView row4_price;
        TextView row5_price;

        public ViewHolder(View itemView) {
            super(itemView);
            more = (TextView) itemView.findViewById(R.id.f0_s1_more);
            row1_num = (TextView) itemView.findViewById(R.id.f0_s1_row1_container).findViewById(R.id.f0_s1_rankingitem_number);
            row2_num = (TextView) itemView.findViewById(R.id.f0_s1_row2_container).findViewById(R.id.f0_s1_rankingitem_number);
            row3_num = (TextView) itemView.findViewById(R.id.f0_s1_row3_container).findViewById(R.id.f0_s1_rankingitem_number);
            row4_num = (TextView) itemView.findViewById(R.id.f0_s1_row4_container).findViewById(R.id.f0_s1_rankingitem_number);
            row5_num = (TextView) itemView.findViewById(R.id.f0_s1_row5_container).findViewById(R.id.f0_s1_rankingitem_number);
            row1_image = (CircleImageView) itemView.findViewById(R.id.f0_s1_row1_container).findViewById(R.id.f0_s1_rankingitem_image);
            row2_image = (CircleImageView) itemView.findViewById(R.id.f0_s1_row2_container).findViewById(R.id.f0_s1_rankingitem_image);
            row3_image = (CircleImageView) itemView.findViewById(R.id.f0_s1_row3_container).findViewById(R.id.f0_s1_rankingitem_image);
            row4_image = (CircleImageView) itemView.findViewById(R.id.f0_s1_row4_container).findViewById(R.id.f0_s1_rankingitem_image);
            row5_image = (CircleImageView) itemView.findViewById(R.id.f0_s1_row5_container).findViewById(R.id.f0_s1_rankingitem_image);
            row1_name = (TextView) itemView.findViewById(R.id.f0_s1_row1_container).findViewById(R.id.f0_s1_rankingitem_name);
            row2_name = (TextView) itemView.findViewById(R.id.f0_s1_row2_container).findViewById(R.id.f0_s1_rankingitem_name);
            row3_name = (TextView) itemView.findViewById(R.id.f0_s1_row3_container).findViewById(R.id.f0_s1_rankingitem_name);
            row4_name = (TextView) itemView.findViewById(R.id.f0_s1_row4_container).findViewById(R.id.f0_s1_rankingitem_name);
            row5_name = (TextView) itemView.findViewById(R.id.f0_s1_row5_container).findViewById(R.id.f0_s1_rankingitem_name);
            row1_price = (TextView) itemView.findViewById(R.id.f0_s1_row1_container).findViewById(R.id.f0_s1_rankingitem_price);
            row2_price = (TextView) itemView.findViewById(R.id.f0_s1_row2_container).findViewById(R.id.f0_s1_rankingitem_price);
            row3_price = (TextView) itemView.findViewById(R.id.f0_s1_row3_container).findViewById(R.id.f0_s1_rankingitem_price);
            row4_price = (TextView) itemView.findViewById(R.id.f0_s1_row4_container).findViewById(R.id.f0_s1_rankingitem_price);
            row5_price = (TextView) itemView.findViewById(R.id.f0_s1_row5_container).findViewById(R.id.f0_s1_rankingitem_price);
        }
    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}