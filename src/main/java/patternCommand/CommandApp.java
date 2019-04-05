package patternCommand;

import patternCommand.commands.CommandReset;
import patternCommand.commands.CommandStart;
import patternCommand.commands.CommandStop;

public class CommandApp {

    public static void main(String[] args) {

        ComputerReceiver cr = new ComputerReceiver();
        UserInvoker ui = new UserInvoker(new CommandStart(cr), new CommandStop(cr), new CommandReset(cr));

        ui.startComputer();
        ui.stopComputer();
        ui.restartComputer();
    }

}
