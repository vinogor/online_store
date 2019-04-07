package patternMarket;

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
    }

    public void showStorage() {
        for (Map.Entry<String, Item> entry : storage.entrySet()) {
            System.out.println("" +
                    " название - " + entry.getValue().getName() +
                    " цена - " + entry.getValue().getPrice() +
                    " кол-во - " + entry.getValue().getQuantity()
            );
        }
    }
}
