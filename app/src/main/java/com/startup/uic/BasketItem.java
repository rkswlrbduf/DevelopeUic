package com.startup.uic;

/**
 * Created by 규열 on 2018-02-05.
 */

public class BasketItem {

    String item_name;
    int item_price;
    int delivery_price;
    String item_image;

    public BasketItem(String item_name, int item_price, String item_image) {
        super();
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_image = item_image;
        this.delivery_price = 0;
    }

    public BasketItem(String item_name, int item_price, String item_image, int delivery_price) {
        super();
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_image = item_image;
        this.delivery_price = delivery_price;
    }
}
