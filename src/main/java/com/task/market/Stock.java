package com.task.market;

import com.task.market.entity.Item;
import com.task.market.entity.ProductItem;

import java.util.ArrayList;
import java.util.List;


// склад
public class Stock {

    private List<ProductItem> stockBalance = new ArrayList<>();

    // вывести складские остатки
    public void printAllStock() {
        System.out.println("Складские остатки:");
        for (int i = 0; i < stockBalance.size(); i++) {
            ProductItem item = stockBalance.get(i);
            System.out.println("    Позиция №" + i + ", " + item);
        }
    }

    // создать новый товар (имя, цена, кол-во)
    void createItem(String name, int price, int quantity) {
        ProductItem item = new ProductItem(name, price, quantity);
        stockBalance.add(item);
        System.out.println("    на склад прибыла новая партия товара номер " + (stockBalance.size()-1) + ", " + item);
    }

    // взять товар (по номеру) со склада
    // убрать -1 шт у существующей позиции
    public Item takeItem(int index) {
        ProductItem productItem = stockBalance.get(index);
        productItem.decQuantity();
        return productItem.getItem();
    }


    // положить +1 ед товара к существующей позиции
    public void putItem(int index) {
        stockBalance.get(index).incQuantity();
    }

    // вернуть номер товара если такой есть
    public int isItemExist(Item item) {
        for (int i = 0; i < stockBalance.size(); i++) {
            if (stockBalance.get(i).getItem().name.equals(item.name)) {
                return i;
            }
        }
        System.out.println("ТАКОГО ТОВАРА НЕ НАЙДЕНО");
        return -1;
    }
}