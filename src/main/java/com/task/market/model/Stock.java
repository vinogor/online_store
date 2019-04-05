package com.task.market.model;

import java.util.Map;
import java.util.TreeMap;

// склад магазина

public class Stock {

    // ключ = id товара
    private Map<Integer, Item> stock = new TreeMap<>();

    public void putItems(int quantity, int id) {
        // если товар с таким id сущетсвует на складе, то...
        if (stock.containsKey(id)) {
            Item item = stock.get(id);
            int oldQuantity = item.getQuantity();
            item.setQuantity(oldQuantity + quantity);
            System.out.println("    кладём товар " + item.getName() + " в количестве " + quantity + " на склад. Теперь его " + (oldQuantity + quantity) + " шт. на складе");
        } else {
            System.out.println("Да это не наш товар!" + id);
        }
    }

    public Item takeItems(int quantity, int id) {
        Item item = stock.get(id);
        int oldQuantity = item.getQuantity();
        item.setQuantity(oldQuantity - quantity);
        System.out.println("    берём товар " + item.getName() + " в количестве " + quantity + " на склад. Теперь его " + (oldQuantity - quantity) + " шт.");
        return item;
    }

    public void createItem(String name, int price, int quantity) {
        Item item = new Item(name, price, quantity);
        stock.put(item.getId(), item);
        System.out.println("    кладём НОВЫЙ товар " + item.getName() + " в количестве " + quantity + " на склад. Теперь его " + quantity + " шт.");
    }

    public void printStock() {
        System.out.println("    == на складе имеется: ");
        for (Map.Entry e : stock.entrySet()) {
            System.out.println(e.getValue());
        }
    }
}

