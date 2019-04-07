package patternMarket;

import patternMarket.commands.*;
import patternMarket.entity.Bucket;
import patternMarket.entity.Buyer;
import patternMarket.entity.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Market {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
        this.putItemInBucket = new CommandPutItemInBucket(store, bucket, buyer);
        this.showBucket = new CommandShowBucket(bucket);
        this.returnItemsFromBucket = new CommandReturnItemsFromBucket(store, bucket);
    }

    public void start() {
        System.out.println("Привет, покупатель!");
        System.out.println("Что хочешь?");
        System.out.println("         1 = показать что есть в магазине");
        System.out.println("    finish = выйти из магазина");
        try {
            buyerDialog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buyerDialog() throws IOException {
        String answer;
        String name;
        int quantity;
        do  {
            answer = reader.readLine();
            switch (answer) {
                case "1":
                    System.out.println("Продавец: вот что у нас есть:");
                    showStore.execute();
                    break;
                case "2":
                    System.out.println("Input name ");
                    name = reader.readLine();
                    System.out.println("Input quantity ");
                    quantity = Integer.parseInt(reader.readLine());
                    buyer.setName(name);
                    buyer.setQuantity(quantity);
                    putItemInBucket.execute();
                    break;
                case "3":
                    System.out.println("Show bucket");
                    showBucket.execute();
                    break;
                case "4":
                    System.out.println("Return items from bucket to store");
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
