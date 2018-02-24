package com.startup.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-12.
 */

public class OrderActivity extends Main_Font_AppCompatFontActivity implements View.OnClickListener {

    @BindView(R.id.order_back)
    ImageButton orderBack;
    @BindView(R.id.order_cancel)
    ImageButton orderCancel;
    @BindView(R.id.order_recyclerview)
    RecyclerView orderRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        ButterKnife.bind(this);

        orderBack.setOnClickListener(this);
        orderCancel.setOnClickListener(this);

        orderRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        orderRecyclerView.setAdapter(new OrderRecyclerViewAdapter(getApplicationContext(), LayoutInflater.from(this)));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.order_back:
                startActivity(new Intent(OrderActivity.this, BasketActivity.class));
                finish();
                break;
            case R.id.order_cancel:
                finish();
                break;
        }
    }

}
