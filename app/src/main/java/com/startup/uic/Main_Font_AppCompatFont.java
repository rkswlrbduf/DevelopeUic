package com.startup.uic;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;

import com.tsengvn.typekit.Typekit;

/**
 * Created by 규열 on 2018-01-05.
 */

public class Main_Font_AppCompatFont extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "AppleSDGothicNeoR.ttf"))
                .addBold(Typekit.createFromAsset(this, "AppleSDGothicNeoB.ttf"))
                .addCustom1(Typekit.createFromAsset(this, "AppleSDGothicNeoM.ttf"))
                .addCustom2(Typekit.createFromAsset(this, "AppleSDGothicNeoSB.ttf"))
                .addCustom3(Typekit.createFromAsset(this, "AppleSDGothicNeoEB.ttf"))
                .addCustom4(Typekit.createFromAsset(this, "SangSangFlowerRoad.otf"));
    }
}
