package com.startup.uic;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class F1_RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final static int HOT_ITEM = 1;
    final static int RANKING_ITEM = 2;
    final static int PICK_ITEM = 3;
    final static int BANNER_ITEM = 4;
    final static int USAGE_ITEM = 5;
    final static int MATERIAL_ITEM = 6;

    private static final int TYPE_LEFT_THIRD = 0;
    private static final int TYPE_MIDDLE_THIRD = 1;
    private static final int TYPE_RIGHT_THIRD = 2;
    private static final int TYPE_LEFT_HALF = 3;
    private static final int TYPE_RIGHT_HALF = 4;

    LayoutInflater inflater;
    Context context;
    View view;
    FragmentManager fm;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;

    MainCallback callback;
    Main_Viewpager mainViewpager;

    private Boolean EDGE = true;
    private Boolean NOT_EDGE = false;

    public F1_RecyclerviewAdapter() {
    }

    public void doWork(MainCallback callback) {
        this.callback = callback;
    }

    public F1_RecyclerviewAdapter(Context context, FragmentManager fm, LayoutInflater inflater) {
        super();
        this.context = context;
        this.fm = fm;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        switch (viewType) {
            case HOT_ITEM:
                view = inflater.inflate(R.layout.f1_section1, parent, false);
                return new NewItemViewHolder(view);
            case RANKING_ITEM:
                view = inflater.inflate(R.layout.f1_section2, parent, false);

                return new RankingItemViewHolder(view);
            case PICK_ITEM:
                view = inflater.inflate(R.layout.f1_section3, parent, false);
                return new PickItemViewHolder(view);
            case BANNER_ITEM:
                view = inflater.inflate(R.layout.f1_section4, parent, false);
                return new BannerItemViewHolder(view);
        }
        return new NewItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                final NewItemViewHolder newItemViewHolder = (NewItemViewHolder) holder;
                F1_Section1_NewItemPagerAdapter section1NewItemPagerAdapter = new F1_Section1_NewItemPagerAdapter(context, 3, inflater);
                newItemViewHolder.viewPager.setAdapter(section1NewItemPagerAdapter);
                newItemViewHolder.dotsIndicator.setViewPager(newItemViewHolder.viewPager);
                final Handler handler = new Handler();
                final Runnable Update = new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage == 3) {
                            currentPage = 0;
                        }
                        newItemViewHolder.viewPager.setCurrentItem(currentPage++, true);
                    }
                };
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, DELAY_MS, PERIOD_MS);
                break;
            case 1:
                final RankingItemViewHolder rankingItemViewHolder = (RankingItemViewHolder) holder;
                F1_Section2_CardFragmentPagerAdapter pagerAdapter = new F1_Section2_CardFragmentPagerAdapter(fm, dpToPixels(2, context));
                F1_Section2_ShadowTransformer fragmentCardSection2ShadowTransformer = new F1_Section2_ShadowTransformer(rankingItemViewHolder.viewPager, pagerAdapter);
                fragmentCardSection2ShadowTransformer.enableScaling(true);
                rankingItemViewHolder.viewPager.setAdapter(pagerAdapter);
                Main_Viewpager.ViewPagerCallback callback = new Main_Viewpager.ViewPagerCallback() {
                    @Override
                    public boolean viewPagercallback() {
                        Log.d("CURRENT ITEM",String.valueOf(rankingItemViewHolder.viewPager.getCurrentItem()));
                        if(rankingItemViewHolder.viewPager.getCurrentItem() != 0 && rankingItemViewHolder.viewPager.getCurrentItem() != getItemCount()-1) {
                            return NOT_EDGE;
                        }
                        return EDGE;
                    }
                };
                ((Main_Viewpager)(((MainActivity)context).findViewById(R.id.main_viewpager))).setCallback(callback);
                rankingItemViewHolder.viewPager.setPageTransformer(false, fragmentCardSection2ShadowTransformer);
                rankingItemViewHolder.viewPager.setOffscreenPageLimit(3);
                break;
            case 2:
                PickItemViewHolder pickItemViewHolder = (PickItemViewHolder) holder;
                GridLayoutManager section3LayoutManager = new GridLayoutManager(context.getApplicationContext(), 6);
                section3LayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        switch (position) {
                            case 0:
                            case 1:
                            case 2:
                                return 2;
                            case 3:
                            case 4:
                                return 3;
                        }
                        return 0;
                    }
                });
                F1_Section3_RecyclerviewAdapter section3RecyclerviewAdapter = new F1_Section3_RecyclerviewAdapter(context, inflater);
                pickItemViewHolder.recyclerView.setLayoutManager(section3LayoutManager);
                pickItemViewHolder.recyclerView.setAdapter(section3RecyclerviewAdapter);
                break;
            case 3:
                BannerItemViewHolder bannerItemViewHolder = (BannerItemViewHolder) holder;
                LinearLayoutManager section4LayoutManager = new LinearLayoutManager(context);
                F1_Section4_RecyclerviewAdapter section4RecyclerviewAdapter = new F1_Section4_RecyclerviewAdapter(context, inflater);
                bannerItemViewHolder.recyclerView.setLayoutManager(section4LayoutManager);
                bannerItemViewHolder.recyclerView.setAdapter(section4RecyclerviewAdapter);
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
                return HOT_ITEM;
            case 1:
                return RANKING_ITEM;
            case 2:
                return PICK_ITEM;
            case 3:
                return BANNER_ITEM;
            case 4:
            case 5:
            case 6:
            default:
                break;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class NewItemViewHolder extends RecyclerView.ViewHolder {

        ViewPager viewPager;
        DotsIndicator dotsIndicator;

        public NewItemViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.hotitem_viewpager);
            dotsIndicator = (DotsIndicator) itemView.findViewById(R.id.dots_indicator);
        }

    }

    class RankingItemViewHolder extends RecyclerView.ViewHolder {

        ViewPager viewPager;
        DotsIndicator dotsIndicator;

        public RankingItemViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.ranking_viewpager);
            dotsIndicator = (DotsIndicator) itemView.findViewById(R.id.dots_indicator);
        }
    }

    class PickItemViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public PickItemViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.section3_recyclerview);
        }

    }

    class BannerItemViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public BannerItemViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.section4_recyclerview);
        }
    }

    public interface MainCallback {
        Main_Viewpager mainCallback();
    }

}