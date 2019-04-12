package marketWithPatternCommand.entity;

import java.util.Map;
import java.util.TreeMap;

public class Store implements StoreInterface {

    private Map<String, Item> storage = new TreeMap<>();

    public void addItem(String name, int price, String currency, int quantity) {

        if (!storage.containsKey(name)) {
            storage.put(name, new Item(name, price, currency, quantity));
        } else {
            storage.get(name).setGivenQuantity(quantity);
        }

        System.out.print("    The store has received items: ");
        storage.get(name).show();
        System.out.println(". Now there ara " + storage.get(name).getQuantity() + " units");
    }

    public void addItem(Item item) {

        if (!storage.containsKey(item.getName())) {
            storage.put(item.getName(), item);
        } else {
            storage.get(item.getName()).setGivenQuantity(item.getQuantity());
        }
        System.out.print("    The store has received items: ");
        item.show();
        System.out.println(". Now there ara " + storage.get(item.getName()).getQuantity() + " units");
    }

    public Item getItems(String name) {
        return storage.get(name);
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
            entry.getValue().show();
            System.out.println();
        }
    }
}