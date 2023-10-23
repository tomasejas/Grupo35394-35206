package tp3;

public abstract class Direction {

	
	public abstract Coordinates goForward();
	
	public abstract Direction rotateLeft(NemoSubmarine submarine);
	
	public abstract Direction rotateRight(NemoSubmarine submarine);
	public abstract boolean equals(Object other);
}
