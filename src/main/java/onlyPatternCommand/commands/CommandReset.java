package onlyPatternCommand.commands;

import onlyPatternCommand.ComputerReceiver;

public class CommandReset implements Command {

    ComputerReceiver computerReceiver;

    public CommandReset(ComputerReceiver computerReceiver) {
        this.computerReceiver = computerReceiver;
    }

    @Override
    public void execute() {
        computerReceiver.reset();
    }
}
