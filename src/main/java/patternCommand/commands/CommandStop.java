package patternCommand.commands;

import patternCommand.ComputerReceiver;

public class CommandStop implements Command {

    ComputerReceiver computerReceiver;

    public CommandStop(ComputerReceiver computerReceiver) {
        this.computerReceiver = computerReceiver;
    }

    @Override
    public void execute() {
        computerReceiver.stop();
    }
}
