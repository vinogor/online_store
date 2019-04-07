package patternCommand2;

import java.util.ArrayList;
import java.util.List;

public class PatternCommand {
    public static void main(String[] args) {

        Receiver receiver = new Receiver();

        receiver.addCommands(new MouseClick());

        receiver.runCommand();

    }
}

interface Command {
    void execute();
}

class MouseClick implements Command {

    @Override
    public void execute() {
        System.out.println("click command");
    }
}

class MousePress implements Command {

    @Override
    public void execute() {
        System.out.println("press command");
    }
}

class Receiver {
//    Command command = new MouseClick();

    List<Command> commands = new ArrayList<>();

    public void addCommands(Command command) {
        commands.add(command);
    }

    void runCommand() {
//        command.execute();
        for (Command c : commands) {
            c.execute();
        }
    }
}