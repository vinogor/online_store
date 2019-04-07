package patternCommand3;

public class Command_ShowBasket implements Command {

    private Commands commands;

    public Command_ShowBasket(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.showBasket();
    }
}