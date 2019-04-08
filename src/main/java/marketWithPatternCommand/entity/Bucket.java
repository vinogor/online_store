package marketWithPatternCommand.entity;

import marketWithPatternCommand.entity.strategyForBucket.CalcActualPriceRUB;
import marketWithPatternCommand.entity.strategyForBucket.CalcActualPriceUSD;
import marketWithPatternCommand.entity.strategyForBucket.Strategy;

import java.util.Map;
import java.util.TreeMap;

public class Bucket {

    private int totalCost = 0;
    private Map<String, Item> bucketStorage = new TreeMap<>();

    public void putItem(String name, Item item) {
        if (bucketStorage.get(name) == null) {
            bucketStorage.put(name, item);
        } else {
            bucketStorage.get(name).setGivenQuantity(item.getQuantity());
        }
        System.out.println("   " +
                " в козину положили " + name +
                " в кол-ве " + item.getQuantity() +
                " шт. Теперь их " + bucketStorage.get(name).getQuantity() +
                " шт.");
        totalCost += calcActualCostOfNewItems(item);
        System.out.println("    Суммарная стоимость всех товаров в корзине: " + totalCost);
    }

    private int calcActualCostOfNewItems(Item item) {

        Strategy strategy = null;
        String currency = item.getCurrency();
        int price = item.getPrice();

        switch (currency) {
            case "USD":
                strategy = new CalcActualPriceUSD();
                break;
            case "RUB":
                strategy = new CalcActualPriceRUB();
                break;
        }

        int actualPrice = strategy.execute(price);
        System.out.println("    Актуальная цена товара " + item.getName() + ": " + actualPrice);
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
            System.out.println("    пусто");
        } else {
            for (Map.Entry<String, Item> entry : bucketStorage.entrySet()) {
                System.out.println("    " +
                        "название - " + entry.getValue().getName() +
                        ", цена - " + entry.getValue().getPrice() +
                        ", валюта - " + entry.getValue().getCurrency() +
                        ", кол-во - " + entry.getValue().getQuantity()
                );
            }
            System.out.println("Суммарная стоимость в рублях: " + totalCost);
        }
    }

    public void clear() {
        bucketStorage.clear();
        totalCost = 0;
    }
}
