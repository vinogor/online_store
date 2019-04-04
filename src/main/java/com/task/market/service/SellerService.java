package com.task.market.service;

import com.task.market.entity.Item;
import com.task.market.entity.ProductItem;
import com.task.market.Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class SellerService {

    public Stock stock;
    private Consumer consumer;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SellerService(Stock stock, Consumer consumer) {
        this.stock = stock;
        this.consumer = consumer;
    }

    public void start() {
        hello();
        showListOfActions();
        try {
            action();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void hello() {
        System.out.println("Приветствуем вас в нашем магазине. Что изволите?");
    }

    private void showListOfActions() {
        System.out.println("    1. Показать список товаров");
        System.out.println("    2. Положить товар в корзину");
        System.out.println("    3. Показать товары в корзине"); // при выборе появляется пункт Удалить товар из корзины
        System.out.println("    4. Очистить корзину полностью");
        System.out.println("    \"finish\" - выход ");
    }

    private void action() throws IOException {

        String action = "";
        int num;

        while (!action.equals("finish")) {
            System.out.println("Введите номер действия: ");
            action = reader.readLine();
            switch (action) {
                case "1":
                    stock.printAllStock();
                    break;
                case "2": // добавить товар по номеру в корзину
                    System.out.println("Введите номер товара и я положу его вам в корзину");
                    num = Integer.parseInt(reader.readLine());
                    // берём со склада ( делает -1 и возвращает товар)
                    Item item = stock.takeItem(num);
                    // кладём к корзину покупателя
                    consumer.putItemInBasket(item);
                    break;
                case "3":
                    consumer.showBasket();
                    break;
                case "4": // очистить корзину (положить всё обратно на склад)
                    for (Map.Entry<String, ProductItem> pair : consumer.getBasket().entrySet()) {
                        int index = stock.isItemExist(pair.getValue().getItem());
                        for (int i = 0; i < pair.getValue().getQuantity(); i++) {
                            stock.putItem(index);
                        }
                    }
                    consumer.clearBasket();
                    break;
                case "finish":
                    break;
                default:
                    System.out.println("Повторите ввод, ничего не понятно!");
                    break;
            }
        }
        System.out.println("Выходим из магазина");
    }
}
