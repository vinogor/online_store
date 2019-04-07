package patternCommand3;

public class Command_PutItemInBasket implements Command {

    private Commands commands;

    public Command_PutItemInBasket(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.putItemInBasket();
    }
}
