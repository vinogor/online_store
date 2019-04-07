package patternMarket;

public class CommandShowStore implements Command {

    private Commands commands;

    public CommandShowStore(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        commands.showStore();
    }
}