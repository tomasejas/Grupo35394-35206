package tp3;

public class Surface extends OfficialOfDepth {

    public OfficialOfDepth ascend(NemoSubmarine submarine ) {
        return this;
    }

    public OfficialOfDepth descend(NemoSubmarine submarine) {
        submarine.depth = new InmersionLevel1();
        return this;
    }

    public boolean launchCapsule() {
    	return true;
    }

    public boolean equals(Object other) {
        return other instanceof Surface;
    }

}
