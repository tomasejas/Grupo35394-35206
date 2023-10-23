package tp3;

public class East extends Direction {

    public Direction rotateLeft(NemoSubmarine submarine ) {
        submarine.direction = new North();
        return this;
    }

    public Direction rotateRight(NemoSubmarine submarine) {
        submarine.direction = new South();
        return this;
    }

    public boolean equals(Object other) {
        return other instanceof East;
    }

    public Coordinates goForward() {
        return new Coordinates(1,0);
    }
}
