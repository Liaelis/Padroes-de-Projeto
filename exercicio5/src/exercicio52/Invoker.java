package exercicio52;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void execut(){
        for (Command c : commands){
            c.execute();
        }
        commands.clear();

    }
}
