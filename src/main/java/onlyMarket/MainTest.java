package onlyMarket;

import onlyMarket.controller.CashDesk;
import onlyMarket.model.Consumer;
import onlyMarket.model.Stock;

public class MainTest {

    public static void main(String[] args) {

//        Reciver c = new Reciver();
//        InvocerCustomer customer = new InvocerCustomer(new ShowItemsOfStoreCommand(c));

//        customer.


        // создали и наполнили склад
        Stock stock = new Stock();
        stock.createItem("Машинка", 100, 5);
        stock.createItem("Пистолет", 50, 3);
        stock.createItem("Фломастеры", 70, 9);

        Consumer consumer = new Consumer("Саша", 1000);

        CashDesk cashDesk = new CashDesk(stock, consumer);

        cashDesk.start();
    }
}

