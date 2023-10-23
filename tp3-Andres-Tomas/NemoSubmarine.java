package tp3;

import java.util.ArrayList;

public class NemoSubmarine {
	
    protected Coordinates coordinates;
    protected Direction direction;
    protected OfficialOfDepth depth;
    
    public NemoSubmarine(Coordinates coordinate, Direction direction) {
        this.coordinates = coordinate;
        this.direction = direction;
        this.depth = new Surface();
     
    }
    public void communication(String instructions) {
        instructions.chars().forEach(instruction -> Commands.commandFor(String.valueOf((char) instruction)).execute(this));
    }
    public Coordinates getPosition() {
    	return this.coordinates;
    }
    public Direction getDirection() {
    	return this.direction;
    }
    public OfficialOfDepth getDepth() {
    	return this.depth;
    }
}