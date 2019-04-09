package marketWithPatternCommand;

import marketWithPatternCommand.commands.*;
import marketWithPatternCommand.entity.Bucket;
import marketWithPatternCommand.entity.Buyer;
import marketWithPatternCommand.entity.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Market {

    private Buyer buyer;
    private Command showStore;
    private Command putItemInBucket;
    private Command showBucket;
    private Command returnItemsFromBucket;
    private Command putBucketToRepo;
    private Command takeBucketFromRepo;

    public Market(Store store, Buyer buyer) {
        this.showStore = new Command1ShowStore(store);
        this.buyer = buyer;
        this.putItemInBucket = new Command2PutItemsInBucket(store, buyer);
        this.showBucket = new Command3ShowBucket(buyer);
        this.returnItemsFromBucket = new Command4ReturnItemsFromBucket(store, buyer);
        this.putBucketToRepo = new Command5PutBucketToRepo(buyer);
        this.takeBucketFromRepo = new Command6TakeBucketFromRepo(buyer);
    }

    public void start() {
        System.out.println("Hi, consumer " + buyer.getName() + "! What do you want?");
        System.out.println("         1 = show store assortment");
        System.out.println("         2 = put item in the bucket");
        System.out.println("         3 = show the contents of the bucket");
        System.out.println("         4 = return items from bucket to store");
        System.out.println("         5 = put bucket to repository");
        System.out.println("         6 = take bucket from repository");
        System.out.println("    finish = leave the store");
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
            System.out.println(" ...input command:");
            answer = reader.readLine();
            switch (answer) {
                case "1":
                    System.out.println("Seller: that's what we have:");
                    showStore.execute();
                    break;
                case "2":
                    System.out.println("Seller: input the item name:");
                    name = reader.readLine();
                    System.out.println("Seller: input the quantity of item:");
                    quantity = Integer.parseInt(reader.readLine());
                    buyer.setNameOfItemToPutInBucket(name);
                    buyer.setQuantityOfItemToPutInBucket(quantity);
                    putItemInBucket.execute();
                    break;
                case "3":
                    System.out.println("Seller: in your bucket are:");
                    showBucket.execute();
                    break;
                case "4":
                    System.out.println("Seller: returning items from the bucket to the store shelves");
                    returnItemsFromBucket.execute();
                    break;
                case "5":
                    System.out.println("Seller: your basket will be stored in the repo at your name: " + buyer.getName());
                    putBucketToRepo.execute();
                    break;
                case "6":
                    System.out.println("Seller: here your bucket, " + buyer.getName() + ": ");
                    takeBucketFromRepo.execute();
                    break;
                case "finish":
                    System.out.println("Seller: come again!");
                    break;
                default:
                    System.out.println("The seller: nothing is clear, repeat please");
                    break;
            }
        } while (!answer.equals("finish"));
        System.out.println("You leave the store");
    }
}