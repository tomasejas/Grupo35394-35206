package tp3;

public class South extends Direction {


    public Direction rotateLeft(NemoSubmarine submarine ) {
        submarine.direction = new East();
        return this;
    }

    public Direction rotateRight(NemoSubmarine submarine) {
        submarine.direction = new West();
        return this;
    }

    public boolean equals(Object other) {
        return other instanceof South;
    }

    public Coordinates goForward() {
        return new Coordinates(0,-1);
    }

}
