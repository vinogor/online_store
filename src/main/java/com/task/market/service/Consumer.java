package com.task.market.service;

import com.task.market.entity.Item;
import com.task.market.entity.ProductItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Consumer {
    public Consumer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    private String name;
    private int money;

//    private List<com.task.market.entity.ProductItem> basket = new ArrayList<>();
    private Map<String, ProductItem> basket = new LinkedHashMap<>();

    public Map<String, ProductItem> getBasket() {
        return basket;
    }

    void putItemInBasket(Item item) {
//        basket.add(item);

        // если такой товар есть, то +1 к количеству
        if (basket.containsKey(item.name)) {
            basket.get(item.name).incQuantity();
        } else {
        // если такого товара нет в корзине, то создаём новый товар
            basket.put(item.name, new ProductItem(item.name, item.price, 1));
        }
    }

    void clearBasket() {
        basket.clear();
    }

    void showBasket() {
        System.out.println("В корзине покупателя " + name + " лежит...");

        if (basket.isEmpty()) {
            System.out.println("    НИЧЕГО");
        } else {
            for (Map.Entry<String, ProductItem> pair : basket.entrySet())
            {
                System.out.println("    товар " + pair.getValue().getName() +
                        ", в количестве " + pair.getValue().getQuantity() +
                        " шт., по цене " + pair.getValue().getPrice());
            }
        }
    }


}
