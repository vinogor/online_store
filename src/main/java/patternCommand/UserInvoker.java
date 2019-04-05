package patternCommand;

// вызывающий
// хранит множетсво команд

import patternCommand.commands.Command;

public class UserInvoker {

    public UserInvoker(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    private Command start;
    private Command stop;
    private Command reset;

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
