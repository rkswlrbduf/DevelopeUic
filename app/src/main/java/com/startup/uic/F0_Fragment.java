package com.startup.uic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class F0_Fragment extends android.support.v4.app.Fragment {

    F0_Adapter adapter;
    RecyclerView recyclerView;
    MainActivity context;

    @Override
    public void onAttach(Activity activity) {
        context = (MainActivity) activity;
        super.onAttach(context);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f0_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.f0_recyclerview);
        adapter = new F0_Adapter(context, context.getSupportFragmentManager(), inflater);
        PreCachingLayoutManager layoutManager = new PreCachingLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        layoutManager.setExtraLayoutSpace(getScreenHeight()*6);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                int action = e.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        rv.stopScroll();
                        /*int position = rv.getChildAdapterPosition(rv.findChildViewUnder(e.getX(),e.getY()));
                        if(position == 0 || position == 1) {
                            rv.stopScroll();
                        }*/
                        break;
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        return view;
    }

    public int getScreenHeight() {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

}
