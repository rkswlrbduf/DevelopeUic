package com.startup.uic;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.fingerpush.android.FingerNotification;
import com.fingerpush.android.FingerPushListener;

/**
 * Created by 규열 on 2018-01-08.
 */

public class IntentService extends FingerPushListener {

    @Override
    public void onMessage(Context context, Bundle data) {

        Intent intent = new Intent(IntentService.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pi = PendingIntent.getActivity(IntentService.this, (int) System.currentTimeMillis(), intent, PendingIntent.FLAG_CANCEL_CURRENT);

        FingerNotification fingerNotification = new FingerNotification(this);
        fingerNotification.setNofiticaionIdentifier((int) System.currentTimeMillis());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fingerNotification.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        } else {
            fingerNotification.setIcon(R.mipmap.ic_launcher);
        }

        fingerNotification.setColor(Color.parseColor("#f47423"));
        fingerNotification.setVibrate(new long[]{0, 500, 600, 1000});
        fingerNotification.setLights(Color.parseColor("#ffff00ff"), 500, 500);
        fingerNotification.showNotification(data, pi);

    }
}