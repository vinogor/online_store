package patternMarket.entity;

import java.util.Map;
import java.util.TreeMap;

public class Bucket {

    private Map<String, Item> bucket = new TreeMap<>();

    public void putItem(String name, Item item) {
        bucket.put(name, item);
    }

    public Map<String, Item> getBucket() {
        return bucket;
    }

    public void show() {
        for (Map.Entry<String, Item> entry : bucket.entrySet()) {
            System.out.println("" +
                    " название - " + entry.getValue().getName() +
                    " цена - " + entry.getValue().getPrice() +
                    " кол-во - " + entry.getValue().getQuantity()
            );
        }
    }
}
