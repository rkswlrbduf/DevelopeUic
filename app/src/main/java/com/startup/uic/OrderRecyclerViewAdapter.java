package com.startup.uic;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 규열 on 2018-02-12.
 */

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final static int SECTION0 = 0;
    final static int SECTION1 = 1;
    final static int SECTION2 = 2;
    final static int SECTION3 = 3;
    final static int SECTION4 = 4;
    final static int SECTION5 = 5;
    final static int SECTION6 = 6;

    final static int ROWCOUNT = 7;

    Context context;
    LayoutInflater inflater;

    public OrderRecyclerViewAdapter(Context context, LayoutInflater inflater) {
        super();
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return SECTION0;
            case 1:
                return SECTION1;
            case 2:
                return SECTION2;
            case 3:
                return SECTION3;
            case 4:
                return SECTION4;
            case 5:
                return SECTION5;
            case 6:
                return SECTION6;
            default:
                return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case SECTION0:
                view = inflater.inflate(R.layout.order_row0, parent, false);
                return new Row0ViewHolder(view);
            case SECTION1:
                view = inflater.inflate(R.layout.order_row1, parent, false);
                return new Row1ViewHolder(view);
            case SECTION2:
                view = inflater.inflate(R.layout.order_row2, parent, false);
                return new Row2ViewHolder(view);
            case SECTION3:
                view = inflater.inflate(R.layout.order_row3, parent, false);
                return new Row3ViewHolder(view);
            case SECTION4:
                view = inflater.inflate(R.layout.order_row4, parent, false);
                return new Row4ViewHolder(view);
            case SECTION5:
                view = inflater.inflate(R.layout.order_row5, parent, false);
                return new Row5ViewHolder(view);
            case SECTION6:
                view = inflater.inflate(R.layout.order_row6, parent, false);
                return new Row6ViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Row0ViewHolder row0ViewHolder;
        switch (position) {
            case 0:
                row0ViewHolder = (Row0ViewHolder)holder;
                row0ViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                row0ViewHolder.recyclerView.setAdapter(new OrderRow0RecyclerViewAdapter(context));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return ROWCOUNT;
    }

    public class Row0ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row0_cardview)
        CustomCardView cardView;
        @BindView(R.id.row0_expand_collapse_button)
        ImageButton expandCollapseButton;
        @BindView(R.id.row0_recyclerview)
        RecyclerView recyclerView;

        public Row0ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            expandCollapseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardView.click();
        }
    }

    public class Row1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row1_cardview)
        CustomCardView cardView;
        @BindView(R.id.row1_expand_collapse_button)
        ImageButton expandCollapseButton;

        public Row1ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            expandCollapseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardView.click();
        }
    }

    public class Row2ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row2_cardview)
        CustomCardView cardView;
        @BindView(R.id.row2_expand_collapse_button)
        ImageButton expandCollapseButton;

        public Row2ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            expandCollapseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardView.click();
        }
    }

    public class Row3ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row3_cardview)
        CustomCardView cardView;
        @BindView(R.id.row3_expand_collapse_button)
        ImageButton expandCollapseButton;

        public Row3ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            expandCollapseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardView.click();

        }
    }

    public class Row4ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.row4_cardview)
        CustomCardView cardView;
        @BindView(R.id.row4_expand_collapse_button)
        ImageButton expandCollapseButton;

        public Row4ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            expandCollapseButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cardView.click();
        }

    }

    public class Row5ViewHolder extends RecyclerView.ViewHolder {

        public Row5ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public class Row6ViewHolder extends RecyclerView.ViewHolder {

        public Row6ViewHolder(View itemView) {
            super(itemView);
        }

    }

}
