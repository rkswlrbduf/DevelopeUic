package com.startup.uic;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class F0_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnTouchListener {

    final static int SECTION0 = 0;
    final static int SECTION1 = 1;
    final static int SECTION2 = 2;
    final static int SECTION3 = 3;
    final static int SECTION4 = 4;

    LayoutInflater inflater;
    Context context;
    FragmentManager fm;

    Section0ViewHolder section0ViewHolder;
    Section1ViewHolder section1ViewHolder;
    Section2ViewHolder section2ViewHolder;
    Section3ViewHolder section3ViewHolder;
    Section4ViewHolder section4ViewHolder;

    Handler handler = null;
    Runnable runnable = null;
    PreCachingLayoutManager layoutManager;

    PagerSnapHelper snapHelper;

    public F0_Adapter(Context context, FragmentManager fm, LayoutInflater inflater) {
        super();
        this.context = context;
        this.fm = fm;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = null;
        switch (viewType) {
            case SECTION0:
                view = inflater.inflate(R.layout.f0_s0, parent, false);
                return new Section0ViewHolder(view);
            case SECTION1:
                view = inflater.inflate(R.layout.f0_s1, parent, false);
                return new Section1ViewHolder(view);
            case SECTION2:
                view = inflater.inflate(R.layout.f0_s2, parent, false);
                return new Section2ViewHolder(view);
            case SECTION3:
                view = inflater.inflate(R.layout.f0_s3, parent, false);
                return new Section3ViewHolder(view);
            case SECTION4:
                view = inflater.inflate(R.layout.f0_s4, parent, false);
                return new Section4ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (position) {
            case 0:
                section0ViewHolder = (Section0ViewHolder) holder;
                layoutManager = new PreCachingLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                if (handler == null) {
                    handler = new Handler();
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (layoutManager.findFirstVisibleItemPosition() != 2) {
                                section0ViewHolder.scrollView.smoothScrollToPosition(layoutManager.findFirstVisibleItemPosition() + 1);
                            } else {
                                section0ViewHolder.scrollView.smoothScrollToPosition(0);
                            }
                            handler.postDelayed(this, 3000);
                        }
                    };
                    handler.postDelayed(runnable, 3000);
                    snapHelper = new PagerSnapHelper();
                    snapHelper.attachToRecyclerView(section0ViewHolder.scrollView);
                }
                layoutManager.setExtraLayoutSpace(2);
                layoutManager.setItemPrefetchEnabled(true);
                layoutManager.setInitialPrefetchItemCount(3);
                section0ViewHolder.scrollView.setLayoutManager(layoutManager);
                section0ViewHolder.scrollView.setAdapter(new F0_S0_Adapter(context));
                section0ViewHolder.scrollView.addItemDecoration(new DotIndicator());
                section0ViewHolder.scrollView.setOnTouchListener(this);
                break;
            case 1:
                section1ViewHolder = (Section1ViewHolder) holder;
                section1ViewHolder.scrollView.setAdapter(new F0_S1_Adapter(context));
                section1ViewHolder.scrollView.setItemTransitionTimeMillis(100);
                section1ViewHolder.scrollView.setItemTransformer(new ViewPagerAnimation.Builder().setMinScale(0.95f).setMaxScale(1f).build());
                section1ViewHolder.scrollView.setOffscreenItems(1);
                break;
            case 2:
                section2ViewHolder = (Section2ViewHolder) holder;
                GridLayoutManager section2LayoutManager = new GridLayoutManager(context.getApplicationContext(), 6);
                section2ViewHolder.recyclerView.setLayoutManager(section2LayoutManager);
                final List<TESTMultipleItem> S2_List = new ArrayList<>();
                S2_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S2_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S2_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S2_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT3));
                S2_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT3));
                F0_S2_Adapter S2_Adapter = new F0_S2_Adapter(context, S2_List);
                S2_Adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                        return S2_List.get(position).getItemType();
                    }
                });
                section2ViewHolder.recyclerView.setAdapter(S2_Adapter);
                section2ViewHolder.recyclerView.setNestedScrollingEnabled(false);
                break;
            case 3:
                section3ViewHolder = (Section3ViewHolder) holder;
                GridLayoutManager section3LayoutManager = new GridLayoutManager(context.getApplicationContext(), 6);
                section3ViewHolder.recyclerView.setLayoutManager(section3LayoutManager);
                final List<TESTMultipleItem> S3_List = new ArrayList<>();
                S3_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S3_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S3_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT2));
                S3_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT3));
                S3_List.add(new TESTMultipleItem(TESTMultipleItem.WEIGHT3));
                F0_S3_Adapter S3_Adapter = new F0_S3_Adapter(context, S3_List);
                S3_Adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                        return S3_List.get(position).getItemType();
                    }
                });
                section3ViewHolder.recyclerView.setAdapter(S3_Adapter);
                section3ViewHolder.recyclerView.setNestedScrollingEnabled(false);
                break;
            case 4:
                section4ViewHolder = (Section4ViewHolder) holder;
                section4ViewHolder.recyclerView.setLayoutManager(new PreCachingLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                section4ViewHolder.recyclerView.setAdapter(new F0_S4_Adapter(context, inflater));
                section4ViewHolder.recyclerView.setNestedScrollingEnabled(false);
                break;
        }
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
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
            default:
                break;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class Section0ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.f0_s0_recyclerview)
        RecyclerView scrollView;

        public Section0ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class Section1ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.f0_s1_recyclerview)
        DiscreteScrollView scrollView;

        public Section1ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class Section2ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.f0_s2_recyclerview)
        RecyclerView recyclerView;

        public Section2ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class Section3ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.f0_s3_recyclerview)
        RecyclerView recyclerView;

        public Section3ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class Section4ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.f0_s4_recyclerview)
        RecyclerView recyclerView;

        public Section4ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                handler.removeCallbacks(runnable);
                break;
            case MotionEvent.ACTION_UP:
                handler.postDelayed(runnable, 3000);
                break;
        }
        return false;
    }

}