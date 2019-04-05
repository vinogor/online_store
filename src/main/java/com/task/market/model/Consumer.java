package com.task.market.model;

import com.task.market.model.Item;

import java.util.Map;
import java.util.TreeMap;

public class Consumer {
    public Consumer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    private String name;
    private int money;

    private Map<Integer, Item> basket = new TreeMap<>();

    public void putOneItem(Item item) {
        int id = item.getId();

        if (basket.containsKey(id)) {
            basket.get(id).incQuantity();
        } else {
            basket.put(id, new Item(id, item.getName(), item.getPrice(), 1));
        }
        System.out.println("    кладём 1 товар " + item.getName() + " в корзину. Теперь его в карзине " + basket.get(id).getQuantity() + " шт.");
    }

    public void showBasket() {

        System.out.println("    == в корзине лежит: ");
        if (basket.isEmpty()) {
            System.out.println("    ничего");
        } else {
            for (Map.Entry e : basket.entrySet()) {
                System.out.println(e.getValue());
            }
        }
    }

    public Map<Integer, Item> getBasket() {
        return basket;
    }

    public void clearBasket() {
        System.out.println("    освобождаем корзину");
        basket = new TreeMap<>();
    }
}
