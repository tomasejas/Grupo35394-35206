package tp3;


import java.util.ArrayList;
import java.util.Arrays;


public abstract class Commands {
	
	public static ArrayList<Commands> commands = new ArrayList<>(
            Arrays.asList(
                    new Descend("d"),
                    new Ascend("u"),
                    new RotateLeft("l"),
                    new RotateRight("r"),
                    new Forward("f"),
                    new Launch("m")));

    public static Commands commandFor(String commandLetter) {
        return commands.stream().filter(command -> command.equals(commandLetter)).findFirst().get();
    }

    public abstract boolean equals(String commandName);

    public abstract void execute(NemoSubmarine submarine);

}
 
