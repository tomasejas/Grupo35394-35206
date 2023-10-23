package tp3;

public class InmersionLevel1 extends OfficialOfDepth {

    public OfficialOfDepth ascend(NemoSubmarine submarine) {
        submarine.depth = new Surface();
        return this;
    }

    public OfficialOfDepth descend(NemoSubmarine submarine) {
        submarine.depth = new ImmersionLevelNotSuitable();
        return this;
    }

    public boolean launchCapsule() {
    	return true;
    }

    public boolean equals(Object other) {
        return other instanceof InmersionLevel1;
    }
}

