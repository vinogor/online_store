package patternMarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Market {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Market(Seller seller) {
        this.seller = seller;
    }

    private Seller seller;

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
        do  {
            answer = reader.readLine();
            switch (answer) {
                case "1":
                    System.out.println("Продавец: вот что у нас есть:");
                    seller.showStore();
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
