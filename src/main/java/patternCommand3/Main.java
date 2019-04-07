package patternCommand3;

public class Main {
    public static void main(String[] args) {

        // объект с описанием реальных действий
        Commands commands = new Commands();

        // класс Юзера
        Bayer bayer = new Bayer(
                new Command_PutItemInBasket(commands),
                new Command_ReturnItemsFromBasket(commands),
                new Command_ShowBasket(commands)
        );


        // запускаем действия Юзера
        bayer.putItem();
        bayer.retBask();
        bayer.shoBask();

    }
}
