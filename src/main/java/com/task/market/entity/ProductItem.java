package com.task.market.entity;

public class ProductItem {

    private int quantity;
    private Item item;

    // складская позиция (карточка + количество)
    public ProductItem(String name, int price, int quantity) {
        this.item = new Item(name, price);
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    // уменьшить кол-во на 1 шт
    public void decQuantity() {
        if(quantity == 0) {
            System.out.println("    Товар " + item.name + "закончился");
        } else {
            quantity--;
//            System.out.println("    Товар " + item.name + " взят со склада. Осталось " + quantity + " штук");
        }
    }

   public void incQuantity() {
        quantity++;
//        System.out.println("    Товар " + item.name + " положили на склад. Его стало " + quantity + " штук");
    }

    public String getName() {
        return item.name;
    }

    public int getPrice() {
        return item.price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return  "название = " + item.name +
                ", цена = " + item.price +
                ", кол-во = " + quantity;
    }
}
