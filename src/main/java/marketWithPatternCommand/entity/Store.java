package marketWithPatternCommand.entity;

import java.util.Map;
import java.util.TreeMap;

public class Store {

    private Map<String, Item> storage = new TreeMap<>();

    public void addItem(String name, int price, String currency, int quantity) {

        if (!storage.containsKey(name)) {
            storage.put(name, new Item(name, price, currency, quantity));
        } else {
            storage.get(name).setGivenQuantity(quantity);
        }
        System.out.println("   " +
                " The store has received items: " + name +
                " in quantity " + quantity +
                " units, price " + price + " " + currency +
                ". Now there ara " + storage.get(name).getQuantity() +
                " units");
    }

    public int getPriceByName(String name) {
        return storage.get(name).getPrice();
    }

    public String getCurrencyByName(String name) {
        return storage.get(name).getCurrency();
    }

    public void takeItems(String name, int quantity) {
        storage.get(name).decQuantity(quantity);
    }

    public void putItems(String name, int quantity) {
        storage.get(name).incQuantity(quantity);
    }

    public void showStorage() {
        for (Map.Entry<String, Item> entry : storage.entrySet()) {
            System.out.println("   " +
                    " name - " + entry.getValue().getName() +
                    ", price - " + entry.getValue().getPrice() +
                    ", currency - " + entry.getValue().getCurrency() +
                    ", quantity - " + entry.getValue().getQuantity()
            );
        }
    }
}