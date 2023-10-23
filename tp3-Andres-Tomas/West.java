package tp3;

public class West extends Direction {

    public Direction rotateLeft(NemoSubmarine submarine ) {
        submarine.direction = new South();
        return this;
    }

    public Direction rotateRight(NemoSubmarine submarine) {
        submarine.direction = new North();
        return this;
    }

    public boolean equals(Object other) {
        return other instanceof West;
    }

    public Coordinates goForward() {
        return new Coordinates(-1,0);
    }
}

