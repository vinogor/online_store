package patternMarket;


public class Main {

    public static void main(String[] args) {


        Store store = new Store();

        store.addItem("Машинка", 100, 10);
        store.addItem("Пистолет", 50, 100);
        store.addItem("Карандаш", 10, 1);

        Seller seller = new Seller(store);

        Market market = new Market(seller);

        market.start();

    }
}
