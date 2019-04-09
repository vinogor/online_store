package onlyMarket;

import onlyMarket.controller.CashDesk;
import onlyMarket.model.Consumer;
import onlyMarket.model.Stock;

public class MainTest {

    public static void main(String[] args) {

        Stock stock = new Stock();
        stock.createItem("Car", 100, 5);
        stock.createItem("Pistol", 50, 3);
        stock.createItem("Pencil", 70, 9);

        Consumer consumer = new Consumer("Sasha", 1000);

        CashDesk cashDesk = new CashDesk(stock, consumer);

        cashDesk.start();
    }
}

