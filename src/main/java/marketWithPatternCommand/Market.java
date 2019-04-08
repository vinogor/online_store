package marketWithPatternCommand;

import marketWithPatternCommand.commands.*;
import marketWithPatternCommand.entity.Bucket;
import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Market {

    private Store store;
    private Bucket bucket;
    private Buyer buyer;
    private Command showStore;
    private Command putItemInBucket;
    private Command showBucket;
    private Command returnItemsFromBucket;

    public Market(Store store) {
        this.store = store;
        this.showStore = new CommandShowStore(store);
        this.bucket = new Bucket();
        this.buyer = new Buyer();
        this.putItemInBucket = new CommandPutItemsInBucket(store, bucket, buyer);
        this.showBucket = new CommandShowBucket(bucket);
        this.returnItemsFromBucket = new CommandReturnItemsFromBucket(store, bucket);
    }

    public void start() {
        System.out.println("Привет, покупатель!");
        System.out.println("Что хочешь?");
        System.out.println("         1 = показать ассортимент магазина");
        System.out.println("         2 = положить товар в корзину");
        System.out.println("         3 = показать содержимое корзины");
        System.out.println("         4 = вернуть товары из корзины");
        System.out.println("    finish = выйти из магазина");
        try {
            buyerDialog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buyerDialog() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        String name;
        int quantity;
        do  {
            System.out.println(" ...введите команду:");
            answer = reader.readLine();
            switch (answer) {
                case "1":
                    System.out.println("Продавец: вот что у нас есть:");
                    showStore.execute();
                    break;
                case "2":
                    System.out.println("Продавец: введите имя товара:");
                    name = reader.readLine();
                    System.out.println("Продавец: введите кол-во товара:");
                    quantity = Integer.parseInt(reader.readLine());
                    buyer.setName(name);
                    buyer.setQuantity(quantity);
                    putItemInBucket.execute();
                    break;
                case "3":
                    System.out.println("Продавец: в вашей корзине лежит:");
                    showBucket.execute();
                    break;
                case "4":
                    System.out.println("Продавец: возвращаю товары из корзины на полки магазина");
                    returnItemsFromBucket.execute();
                    break;
                case "finish":
                    System.out.println("Продавец: приходите ещё!");
                    break;
                default:
                    System.out.println("Продавец: ничего непонятно, повторите");
                    break;
            }
        } while (!answer.equals("finish"));
        System.out.println("Выходим из магазина");
    }
}
