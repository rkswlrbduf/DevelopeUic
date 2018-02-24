package com.startup.uic;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 규열 on 2018-01-24.
 */

public class Category {

    Map maps;

    public Category(int size, ArrayList<String> list) {
        super();
        maps = new Map();
        for (int i = 0; i < size; i++) {
            maps.map.add(i, new Map());
            maps.map.get(i).setString(list.get(i));
        }
    }

    public void setMidIndex(int midIndex, int size, ArrayList<String> list) {
        for (int i = 0; i < size; i++) {
            Log.d("TAG", String.valueOf(size));
            maps.map.get(midIndex).map.add(i, new Map());
            maps.map.get(midIndex).map.get(i).setString(list.get(i));
        }
    }

    public void setSmaIndex(int midIndex, int smaIndex, int size, ArrayList<String> list) {
        for (int i = 0; i < size; i++) {
            maps.map.get(midIndex).map.get(smaIndex).map.add(i, new Map());
            maps.map.get(midIndex).map.get(smaIndex).map.get(i).setString(list.get(i));
        }
    }


    class Map {

        ArrayList<Map> map;
        String string;

        public Map() {
            super();
            map = new ArrayList<>();
            string = null;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

}
