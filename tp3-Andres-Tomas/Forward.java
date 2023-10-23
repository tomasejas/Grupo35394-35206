package tp3;

public class Forward extends Commands {
	private String name;

    public Forward(String name) {
        this.name = name;
    }

    public boolean equals(String commandName) {
        return this.name.equals(commandName);
    }

    public void execute(NemoSubmarine submarine) {
    	submarine.coordinates.addCoordinate(submarine.direction.goForward(),submarine);
    }
}
