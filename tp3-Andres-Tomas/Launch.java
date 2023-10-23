package tp3;

public class Launch extends Commands {
	private String name;

    public Launch(String name) {
        this.name = name;
    }

    public boolean equals(String commandName) {
        return this.name.equals(commandName);
    }

    public void execute(tp3.NemoSubmarine submarine) {
    	submarine.depth.launchCapsule();

    }

}
