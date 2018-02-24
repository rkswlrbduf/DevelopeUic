package com.startup.uic;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-05.
 */

public class BasketActivity extends Main_Font_AppCompatFontActivity implements View.OnClickListener {

    @BindView(R.id.basket_cancel)
    ImageButton basketCancel;
    @BindView(R.id.basket_sum)
    TextView basketSum;
    @BindView(R.id.basket_buy)
    Button basketBuy;
    @BindView(R.id.basket_recyclerview)
    RecyclerView basketRecyclerView;
    @BindView(R.id.basket_check_all)
    LottieAnimationView basketCheckAll;
    @BindView(R.id.basket_check_count)
    TextView checkCount;
    @BindView(R.id.basket_empty_container)
    LinearLayout emptyContainer;
    @BindView(R.id.bottom)
    RelativeLayout bottom;

    BasketAdapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<BasketItem> items;

    boolean checkToggle = false;
    BasketAdapter.MyViewHolder viewHolder;

    ValueAnimator checkAnimator;
    ValueAnimator unCheckAnimator;

    int sum = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basket_activity);

        ButterKnife.bind(this);

        items = new ArrayList<BasketItem>() {{
            add(new BasketItem("원단 1", 3500, "image1", 2500));
            add(new BasketItem("원단 2", 3500, "image2", 2500));
            add(new BasketItem("원단 3", 3500, "image3", 2500));
        }};

        adapter = new BasketAdapter(BasketActivity.this, LayoutInflater.from(this), items);
        layoutManager = new LinearLayoutManager(BasketActivity.this, LinearLayoutManager.VERTICAL, false);

        basketBuy.setOnClickListener(this);
        basketCancel.setOnClickListener(this);
        basketCheckAll.setOnClickListener(this);

        basketRecyclerView.setLayoutManager(layoutManager);
        basketRecyclerView.setAdapter(adapter);

        checkAnimator = ValueAnimator.ofFloat(0.2f, 0.5f).setDuration(1500);
        checkAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                basketCheckAll.setProgress((float) valueAnimator.getAnimatedValue());
            }
        });

        unCheckAnimator = ValueAnimator.ofFloat(0.6f, 0.8f).setDuration(1000);
        unCheckAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                basketCheckAll.setProgress((float) valueAnimator.getAnimatedValue());
            }
        });

        this.checkCount.setText("전체선택(0/" + items.size() + ")");
        basketSum.setText(String.valueOf(0));
        if(items.size() == 0) checkItemsSize();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.basket_cancel:
                finish();
                break;
            case R.id.basket_buy:
                for(int i = 0;i<adapter.getItemCount();i++) {

                }
                startActivity(new Intent(BasketActivity.this, OrderActivity.class));
                finish();
                break;
            case R.id.basket_check_all:
                if (!checkToggle) {
                    checkAnimator.start();
                    this.checkCount.setText("전체선택(" + items.size() + "/" + items.size() + ")");
                } else {
                    unCheckAnimator.start();
                    this.checkCount.setText("전체선택(0/" + items.size() + ")");
                }
                sum = 0;
                for (int i = 0; i < items.size(); i++) {
                    if (viewHolder != null) viewHolder = null;
                    viewHolder = (BasketAdapter.MyViewHolder) basketRecyclerView.findViewHolderForAdapterPosition(i);
                    if (!checkToggle) {
                        if (!viewHolder.toggle) {
                            viewHolder.checkAnimator.start();
                            adapter.checkCount++;
                            viewHolder.toggle = true;
                        }
                    } else {
                        if (viewHolder.toggle) {
                            viewHolder.unCheckAnimator.start();
                            adapter.checkCount--;
                            viewHolder.toggle = false;
                        }
                    }
                    if(viewHolder.toggle) {
                        sum += Integer.valueOf(viewHolder.itemSumPrice.getText().toString().replaceAll("\\D+",""));
                    }
                }
                basketSum.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(sum));
                checkToggle = !checkToggle;
                break;
        }
    }

    public void checkAllFromAdapter(int checkCount) {
        if (checkCount == 0 && checkToggle) {
            unCheckAnimator.start();
            checkToggle = !checkToggle;
        } else if (checkCount != 0 && !checkToggle) {
            checkAnimator.start();
            checkToggle = !checkToggle;
        }
        this.checkCount.setText("전체선택(" + checkCount + "/" + items.size() + ")");
        sum = 0;
        for(int i = 0;i<adapter.items.size();i++) {
            viewHolder = (BasketAdapter.MyViewHolder) basketRecyclerView.findViewHolderForAdapterPosition(i);
            if(viewHolder.toggle) {
                sum += Integer.valueOf(viewHolder.itemSumPrice.getText().toString().replaceAll("\\D+",""));
            }
        }
        basketSum.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format((sum)));
    }

    public void updateSum() {
        sum = 0;
        for(int i = 0;i<adapter.items.size();i++) {
            viewHolder = (BasketAdapter.MyViewHolder) basketRecyclerView.findViewHolderForAdapterPosition(i);
            if(viewHolder.toggle) {
                sum += Integer.valueOf(viewHolder.itemSumPrice.getText().toString().replaceAll("\\D+",""));
            }
        }
        basketSum.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(sum));
    }

    public void updateAfterDelete(int checkCount) {
        sum = 0;
        for(int i = 0;i<adapter.items.size();i++) {
            viewHolder = (BasketAdapter.MyViewHolder) basketRecyclerView.findViewHolderForAdapterPosition(i);
            if(viewHolder.toggle) {
                sum += Integer.valueOf(viewHolder.itemSumPrice.getText().toString().replaceAll("\\D+",""));
            }
        }
        basketSum.setText(NumberFormat.getNumberInstance(Locale.getDefault()).format(sum));
        this.checkCount.setText("전체선택(" + checkCount +"/" + items.size() + ")");
        if(checkCount==0 && checkToggle) {
            unCheckAnimator.start();
            checkToggle = !checkToggle;
        }
        if(items.size() == 0) checkItemsSize();
    }

    public void checkItemsSize() {
        emptyContainer.setVisibility(View.VISIBLE);
        bottom.setVisibility(View.INVISIBLE);
    }

}
