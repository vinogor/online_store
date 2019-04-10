package onlyPatternCommand.commands;

import onlyPatternCommand.ComputerReceiver;

public class CommandStart implements Command {

    ComputerReceiver computerReceiver;

    public CommandStart(ComputerReceiver computerReceiver) {
        this.computerReceiver = computerReceiver;
    }

    @Override
    public void execute() {
        computerReceiver.start();
    }
}
