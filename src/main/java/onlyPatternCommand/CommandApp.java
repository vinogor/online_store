package onlyPatternCommand;

import onlyPatternCommand.commands.CommandReset;
import onlyPatternCommand.commands.CommandStart;
import onlyPatternCommand.commands.CommandStop;

public class CommandApp {

    public static void main(String[] args) {

        ComputerReceiver cr = new ComputerReceiver();
        UserInvoker ui = new UserInvoker(new CommandStart(cr), new CommandStop(cr), new CommandReset(cr));

        ui.startComputer();
        ui.stopComputer();
        ui.restartComputer();
    }

}
