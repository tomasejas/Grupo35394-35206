package tp3;

public class RotateLeft extends Commands {
	private String name;

    public RotateLeft(String name) {
        this.name = name;
    }

    public boolean equals(String commandName) {
        return this.name.equals(commandName);
    }

    public void execute(NemoSubmarine submarine) {
        submarine.direction.rotateLeft(submarine);
    }
}
