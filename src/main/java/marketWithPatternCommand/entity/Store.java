package marketWithPatternCommand.entity;

import java.util.Map;
import java.util.TreeMap;

public class Store {

    private Map<String, Item> storage = new TreeMap<>();

    public void addItem(String name, int price, int quantity) {

        if (!storage.containsKey(name)) {
            storage.put(name, new Item(name, price, quantity));
        } else {
            storage.get(name).setGivenQuantity(quantity);
        }
        System.out.println("    в магазин поступил товар: " + name + " в кол-ве " + quantity + "шт. Теперь их " + storage.get(name).getQuantity() + " шт");

    }

    public int getPriceByName(String name) {
        return storage.get(name).getPrice();
    }

    public void takeItems(String name, int quantity) {
        storage.get(name).decQuantity(quantity);
    }

    public void putItems(String name, int quantity) {
        storage.get(name).incQuantity(quantity);
    }


    public void showStorage() {
        for (Map.Entry<String, Item> entry : storage.entrySet()) {
            System.out.println("    " +
                    "название - " + entry.getValue().getName() +
                    ", цена - " + entry.getValue().getPrice() +
                    ", кол-во - " + entry.getValue().getQuantity()
            );
        }
    }
}
