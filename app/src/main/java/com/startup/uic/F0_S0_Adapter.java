package com.startup.uic;

/**
 * Created by 규열 on 2018-01-05.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class F0_S0_Adapter extends RecyclerView.Adapter<F0_S0_Adapter.ViewHolder> {

    Context context;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public F0_S0_Adapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                Picasso.with(context).load(url+"image1.png").fit().centerCrop().into(holder.s1_image);
                break;
            case 1:
                Picasso.with(context).load(url+"image2.png").fit().centerCrop().into(holder.s1_image);
                break;
            case 2:
                Picasso.with(context).load(url+"image3.png").fit().centerCrop().into(holder.s1_image);
                break;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.f0_s0_viewpager,parent,false);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView s1_image;
        TextView s1_mainname;
        TextView s1_subname;

        public ViewHolder(View itemView) {
            super(itemView);
            s1_image = (ImageView)itemView.findViewById(R.id.f0_s0_imageview);
            s1_mainname = (TextView)itemView.findViewById(R.id.f0_s0_mainname);
            s1_subname = (TextView)itemView.findViewById(R.id.f0_s0_subname);
        }
    }

}