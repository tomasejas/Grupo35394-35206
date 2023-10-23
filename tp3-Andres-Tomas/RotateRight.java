package tp3;

public class RotateRight extends Commands {
	 private String name;

	    public RotateRight(String name) {
	        this.name = name;
	    }

	    public boolean equals(String commandName) {
	        return this.name.equals(commandName);
	    }

	    public void execute(NemoSubmarine submarine) {
	        submarine.direction.rotateRight(submarine);
	    }

}
