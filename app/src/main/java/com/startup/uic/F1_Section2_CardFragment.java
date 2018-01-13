package com.startup.uic;

/**
 * Created by 규열 on 2018-01-05.
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class F1_Section2_CardFragment extends Fragment {

    private CardView cardView;
    final static String url = "http://rkswlrbduf.cafe24.com/Uic/Image/";

    public static Fragment getInstance(int position) {
        F1_Section2_CardFragment f = new F1_Section2_CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1_section2_viewpager, container, false);

        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        Picasso.with(getContext()).load(url+"f1_section2_1.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.row1_rankingitem_image));
        Picasso.with(getContext()).load(url+"f1_section2_2.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.row2_rankingitem_image));
        Picasso.with(getContext()).load(url+"f1_section2_3.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.row3_rankingitem_image));
        Picasso.with(getContext()).load(url+"f1_section2_4.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.row4_rankingitem_image));
        Picasso.with(getContext()).load(url+"f1_section2_5.png").fit().centerCrop().into((ImageView)view.findViewById(R.id.row5_rankingitem_image));

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}