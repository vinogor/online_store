package onlyPatternCommand;

import onlyPatternCommand.commands.Command;

public class UserInvoker {

    private Command start;
    private Command stop;
    private Command reset;

    public UserInvoker(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }
    void stopComputer() {
        stop.execute();
    }
    void restartComputer() {
        reset.execute();
    }
}
