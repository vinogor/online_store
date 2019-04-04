package com.task.market;

import com.task.market.service.Consumer;
import com.task.market.service.SellerService;

public class Main {

    public static void main(String[] args) {

        Stock stock = new Stock();
        stock.createItem("Машинка", 100, 3);
        stock.createItem("Пистолет", 50, 5);
        stock.createItem("Фломастеры", 75, 9);

//        stock.printAllStock();

        Consumer consumer = new Consumer("Саша", 500);
//        consumer.showBasket();

        System.out.println();
        SellerService sellerService = new SellerService(stock, consumer);
        sellerService.start();

    }
}
