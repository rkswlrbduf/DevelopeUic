package com.startup.uic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-05.
 */

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.MyViewHolder> {

    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    Context context;
    LayoutInflater inflater;
    ArrayList<BasketItem> items;
    ArrayList<BasketItem> checkItems;
    int checkCount = 0;

    public BasketAdapter(Context context, LayoutInflater inflater, ArrayList<BasketItem> items) {
        super();
        this.context = context;
        this.inflater = inflater;
        this.items = items;
    }

    public int GetCheckItem() {
        return items.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.basket_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BasketItem item = items.get(position);
        holder.itemName.setText(item.item_name);
        holder.itemCount.setText("1");
        Picasso.with(context).load(url + item.item_image + ".png").centerCrop().resize(dipToPixels(context, 72),dipToPixels(context, 72)).into(holder.itemImage);
        holder.itemMainPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(item.item_price * Integer.valueOf(holder.itemCount.getText().toString())) + "원");
        holder.itemSubPrice.setText(holder.itemMainPrice.getText());
        holder.itemDeliveryPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(item.delivery_price) + "원");
        holder.itemSumPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(item.delivery_price + item.item_price) + "원");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static int dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.checkbox)
        LottieAnimationView lottieAnimationView;
        @BindView(R.id.basket_name)
        TextView itemName;
        @BindView(R.id.basket_main_price)
        TextView itemMainPrice;
        @BindView(R.id.basket_sub_price)
        TextView itemSubPrice;
        @BindView(R.id.basket_delivery_price)
        TextView itemDeliveryPrice;
        @BindView(R.id.basket_count)
        TextView itemCount;
        @BindView(R.id.basket_delete)
        ImageButton itemDelete;
        @BindView(R.id.basket_decrease)
        ImageButton itemDecrease;
        @BindView(R.id.basket_increase)
        ImageButton itemIncrease;
        @BindView(R.id.basket_sum_price)
        TextView itemSumPrice;
        @BindView(R.id.basket_image)
        ImageView itemImage;

        ValueAnimator checkAnimator;
        ValueAnimator unCheckAnimator;

        boolean toggle;

        public MyViewHolder(View itemView) {

            super(itemView);

            ButterKnife.bind(this, itemView);
            toggle = false;

            lottieAnimationView.setOnClickListener(this);
            itemIncrease.setOnClickListener(this);
            itemDecrease.setOnClickListener(this);
            itemDelete.setOnClickListener(this);

            checkAnimator = ValueAnimator.ofFloat(0.2f, 0.5f).setDuration(1500);
            checkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    lottieAnimationView.setProgress((float) valueAnimator.getAnimatedValue());
                }
            });

            unCheckAnimator = ValueAnimator.ofFloat(0.6f, 0.8f).setDuration(1000);
            unCheckAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    lottieAnimationView.setProgress((float) valueAnimator.getAnimatedValue());
                }
            });

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.checkbox:
                    if (!toggle) {
                        checkAnimator.start();
                        checkCount++;
                    } else {
                        unCheckAnimator.start();
                        checkCount--;
                    }
                    toggle = !toggle;
                    ((BasketActivity) context).checkAllFromAdapter(checkCount);
                    break;
                case R.id.basket_decrease:
                    itemCount.setText(String.valueOf(Integer.valueOf(itemCount.getText().toString()) - 1));
                    itemMainPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(items.get(getAdapterPosition()).item_price * Integer.valueOf(itemCount.getText().toString())) + "원");
                    itemSubPrice.setText(itemMainPrice.getText());
                    itemSumPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(Integer.valueOf(itemDeliveryPrice.getText().toString().replaceAll("\\D+","")) + Integer.valueOf(itemMainPrice.getText().toString().replaceAll("\\D+",""))) + "원");
                    ((BasketActivity) context).updateSum();
                    break;
                case R.id.basket_increase:
                    itemCount.setText(String.valueOf(Integer.valueOf(itemCount.getText().toString()) + 1));
                    itemMainPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(items.get(getAdapterPosition()).item_price * Integer.valueOf(itemCount.getText().toString())) + "원");
                    itemSubPrice.setText(itemMainPrice.getText());
                    itemSumPrice.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(Integer.valueOf(itemDeliveryPrice.getText().toString().replaceAll("\\D+","")) + Integer.valueOf(itemMainPrice.getText().toString().replaceAll("\\D+",""))) + "원");
                    ((BasketActivity) context).updateSum();
                    break;
                case R.id.basket_delete:
                    items.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    if(toggle) checkCount--;
                    ((BasketActivity) context).updateAfterDelete(checkCount);
                    break;
            }

        }

    }

}
