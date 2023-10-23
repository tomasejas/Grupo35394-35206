package tp3;

public abstract class OfficialOfDepth {
	
	public abstract OfficialOfDepth ascend(NemoSubmarine submarine);
	public abstract OfficialOfDepth descend(NemoSubmarine submarine	);
	public abstract boolean launchCapsule();
	public abstract boolean equals(Object other);
}
