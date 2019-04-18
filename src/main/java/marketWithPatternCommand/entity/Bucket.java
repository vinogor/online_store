package marketWithPatternCommand.entity;

import marketWithPatternCommand.entity.strategyForBucket.CalcActualPriceRUB;
import marketWithPatternCommand.entity.strategyForBucket.CalcActualPriceUSD;
import marketWithPatternCommand.entity.strategyForBucket.Strategy;
import org.springframework.stereotype.Component;

import static marketWithPatternCommand.Constants.*;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

@Component
public class Bucket implements Serializable {
    static final long serialVersionUID = 1L;

    private int totalCost = 0;
    private Map<String, Item> bucketStorage = new TreeMap<>();

    public Bucket() {
    }

    public Bucket(Bucket bucket) {
        this.bucketStorage = new TreeMap<>(bucket.getBucketStorage());
        this.totalCost = bucket.getTotalCost();
    }

    public void putItem(String name, Item item) {
        if (bucketStorage.get(name) == null) {
            bucketStorage.put(name, item);
        } else {
            bucketStorage.get(name).setGivenQuantity(item.getQuantity());
        }
        System.out.println("   " +
                " put in the basket " + name +
                ", in quantity " + item.getQuantity() +
                ". Now there are " + bucketStorage.get(name).getQuantity() +
                " units");
        totalCost += calcActualCostOfNewItems(item);
        System.out.println("    Total price of all items in the bucket: " + totalCost);
    }

    private int calcActualCostOfNewItems(Item item) {
        Strategy strategy = null;
        String currency = item.getCurrency();
        int price = item.getPrice();

        switch (currency) {
            case USD:
                strategy = new CalcActualPriceUSD();
                break;
            case RUB:
                strategy = new CalcActualPriceRUB();
                break;
        }

        int actualPrice = strategy.execute(price);
        System.out.println("    Current price of item " + item.getName() + ": " + actualPrice);
        return actualPrice * item.getQuantity();

    }

    public int getTotalCost() {
        return totalCost;
    }

    public Map<String, Item> getBucketStorage() {
        return bucketStorage;
    }

    public void show() {
        if (bucketStorage.isEmpty()) {
            System.out.println("    empty");
        } else {
            for (Map.Entry<String, Item> entry : bucketStorage.entrySet()) {
                System.out.println("   " +
                        " name - " + entry.getValue().getName() +
                        ", price - " + entry.getValue().getPrice() +
                        ", currency - " + entry.getValue().getCurrency() +
                        ", quantity - " + entry.getValue().getQuantity()
                );
            }
            System.out.println("Total price in rubles: " + totalCost);
        }
    }

    public void clear() {
        bucketStorage.clear();
        totalCost = 0;
    }
}