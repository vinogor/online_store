package patternCommand3;

public class Command_ReturnItemsFromBasket implements Command{

    private Commands commands;

    public Command_ReturnItemsFromBasket(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.returnItemsFromBasket();
    }
}
