package tp3;

public class Descend extends Commands {
	private String name;
    public Descend(String name) {
        this.name = name;
    }

    
    public boolean equals(String commandName) {
        return this.name.equals(commandName);
    }

	public void execute(NemoSubmarine submarine) {
        submarine.depth.descend(submarine);
    }
}
