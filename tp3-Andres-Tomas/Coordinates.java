package tp3;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
    
	public Coordinates addCoordinate(Coordinates newCoordinate, NemoSubmarine submarine) {
		int newX = this.x + newCoordinate.x;
		int newY = this.y + newCoordinate.y;
		submarine.coordinates = new Coordinates(newX, newY);
		return this;
	}
	public boolean equals(Coordinates coordinates) {
		return this.x == coordinates.x && this.y == coordinates.y;
	}
}

