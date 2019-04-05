package com.task.market.controller;

import com.task.market.model.Consumer;
import com.task.market.model.Item;
import com.task.market.model.Stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// касса

// reciver

public class CashDesk {

    private Stock stock;
    private Consumer consumer;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public CashDesk(Stock stock, Consumer consumer) {
        this.stock = stock;
        this.consumer = consumer;
    }

    public void start() {
        greeting();
        showListOfActions();
        try {
            action();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void greeting() {
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
        int id;

        while (!action.equals("finish")) {
            System.out.println("Введите номер действия: ");
            action = reader.readLine();



            switch (action) {
                case "1": // вывести на экран

                    stock.printStock();
                    break;
                case "2": // добавить товар по номеру в корзину
                    System.out.println("Введите номер товара и я положу его вам в корзину");
                    id = Integer.parseInt(reader.readLine());
                    // берём со склада ( делаем -1 и возвращает товар)
                    Item item = stock.takeItems(1, id);
                    // кладём к корзину покупателя
                    consumer.putOneItem(item);
                    break;
                case "3":
                    consumer.showBasket();
                    break;
                case "4": // очистить корзину (+ положить всё обратно на склад)
                    for (Map.Entry<Integer, Item> pair : consumer.getBasket().entrySet()) {
                        Item itemFromBasket = pair.getValue();
                        stock.putItems(itemFromBasket.getQuantity(), itemFromBasket.getId());
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