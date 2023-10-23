package tp3;

public class ImmersionLevelNotSuitable extends OfficialOfDepth {

	public OfficialOfDepth ascend(NemoSubmarine submarine) {
		submarine.depth = new InmersionLevel1();
		return this;
	   }

	   public OfficialOfDepth descend(NemoSubmarine submarine) {
	       return this;
	   }

	   public boolean launchCapsule() {
		   throw new RuntimeException("La capsula no es apta para la profundidad.");
	   }

	public boolean equals(Object other) {
		return other instanceof ImmersionLevelNotSuitable;
	}

}
