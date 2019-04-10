package marketWithPatternCommand.entity;

import static marketWithPatternCommand.Constants.RUB;

public class Buyer {

    private String name;
    private int money;
    private Bucket bucket;

    private String nameOfItemToPutInBucket;
    private int quantityOfItemToPutInBucket;

    public Buyer(String name, int money) {
        this.name = name;
        this.money = money;
        this.bucket = new Bucket();
        System.out.println("   "+
                " New Buyer was created! " +
                "Name: " + name +
                ", money: " + money + " " + RUB);
    }

    public Buyer(Buyer buyer) {
        this.name = buyer.getName();
        this.money = buyer.getMoney();
        this.bucket = new Bucket(buyer.getBucket());
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getQuantityOfItemToPutInBucket() {
        return quantityOfItemToPutInBucket;
    }

    public void setQuantityOfItemToPutInBucket(int quantityOfItemToPutInBucket) {
        this.quantityOfItemToPutInBucket = quantityOfItemToPutInBucket;
    }

    public void setNameOfItemToPutInBucket(String nameOfItemToPutInBucket) {
        this.nameOfItemToPutInBucket = nameOfItemToPutInBucket;
    }

    public String getNameOfItemToPutInBucket() {
        return nameOfItemToPutInBucket;
    }
}
