package marketWithPatternCommand.entity;

import java.util.Map;
import java.util.TreeMap;

public class Bucket {

    private Map<String, Item> bucket = new TreeMap<>();

    public void putItem(String name, Item item) {
        if (bucket.get(name) == null) {
            bucket.put(name, item);
        } else {
            bucket.get(name).setGivenQuantity(item.getQuantity());
        }
        System.out.println("    в козину положили " + name + " в кол-ве " + item.getQuantity() + "шт. Теперь их " + bucket.get(name).getQuantity() + " шт");
    }

    public Map<String, Item> getBucket() {
        return bucket;
    }

    public void show() {
        if (bucket.isEmpty()) {
            System.out.println("    пусто");
        } else {
            for (Map.Entry<String, Item> entry : bucket.entrySet()) {
                System.out.println("    " +
                        "название - " + entry.getValue().getName() +
                        ", цена - " + entry.getValue().getPrice() +
                        ", кол-во - " + entry.getValue().getQuantity()
                );
            }
        }
    }
}
