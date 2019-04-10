package marketWithPatternCommand.entity;

import java.util.Calendar;

public class ItemWithShelfLife extends Item {

    @FieldToSetDate(dateType = 1)
    private Calendar dateOfDelivery;
    @FieldToSetDate(dateType = 2)
    private Calendar dateOfShelfLife;
    private String name;
    private int price;
    private String currency;
    private int quantity;

    public ItemWithShelfLife(String name, int price, String currency, int quantity) {
        super(name, price, currency, quantity);
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.quantity = quantity;
    }

    public Calendar getDateOfDelivery() {
        return dateOfDelivery;
    }

    public Calendar getDateOfShelfLife() {
        return dateOfShelfLife;
    }

    @Override
    public void show() {
        System.out.print("" +
                " name - " + name +
                ", price - " + price +
                ", currency - " + currency +
                ", quantity - " + quantity +
                ", dateOfDelivery - " + dateOfDelivery.getTime() +
                ", dateOfShelfLife - " + dateOfShelfLife.getTime()
        );
    }
}