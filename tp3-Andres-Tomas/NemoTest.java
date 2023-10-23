package tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class NemoTest {
	private Coordinates coordinateOrigin;
	private Coordinates coordinateForwardEast;
	private Coordinates coordinateForwardSouth;
	private Coordinates coordinateForwardWest;
	private Coordinates coordinateForwardNorth;
	private Direction directionNorth;
	private Direction directionWest;
	private Direction directionEast;
	private Direction directionSouth;
	private OfficialOfDepth surface;
	private OfficialOfDepth immersionSuitable;
	private OfficialOfDepth immersionNotSuitable;
	@BeforeEach public void setUp() {
		coordinateOrigin = new Coordinates(0,0);
		coordinateForwardEast = new Coordinates(1,0);
		coordinateForwardSouth = new Coordinates(0,-1);
		coordinateForwardWest = new Coordinates(-1,0);
		coordinateForwardNorth = new Coordinates(0,1);
		directionNorth = new North();
		directionSouth = new South();
		directionWest = new West();
		directionEast = new East();
		surface = new Surface();
		immersionSuitable = new InmersionLevel1();
		immersionNotSuitable = new ImmersionLevelNotSuitable();
	}
	@Test public void descendFromSurface() {
        NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionEast);
        submarine.communication("d");
        assertEquals(immersionSuitable,submarine.getDepth());
	}
	
	@Test public void ascendToSurface() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionWest);
		submarine.communication("du");
		assertEquals(surface,submarine.getDepth());
	}
	
	@Test public void ascendButIsOnSurface() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionWest);
		submarine.communication("u");
		assertEquals(surface,submarine.getDepth());
	}
	@Test public void descendAndDescend() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionWest);
		submarine.communication("dd");
		assertEquals(immersionNotSuitable,submarine.getDepth());
	}
	@Test public void descendAndAscend() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionWest);
		submarine.communication("ddu");
		assertEquals(immersionSuitable,submarine.getDepth());
	}
	@Test public void launchCapsuleSurface() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionWest);
		submarine.communication("m");
		assertTrue(submarine.getDepth().launchCapsule());
	}
	@Test public void launchCapsuleInmersionLevel1() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionWest);
		submarine.communication("dm");
		assertTrue(submarine.getDepth().launchCapsule());
	}

	
	@Test public void rotateDirectionToLeft() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin,directionNorth );
		submarine.communication("l");
		assertEquals(directionWest,submarine.getDirection());
	}
	
	@Test public void rotateDirectionToRight() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("r");
		assertEquals(directionEast,submarine.getDirection());
	}
	@Test public void rotateDirectionToRightAndLeft() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("rl");
		assertEquals(directionNorth,submarine.getDirection());
	}
@Test public void rotateDirectionToLeftAndRight() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("lr");
		assertEquals(directionNorth,submarine.getDirection());
	}
	@Test public void rotateDirectionToLeftAndLeft() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("ll");
		assertEquals(directionSouth,submarine.getDirection());
	}
	@Test public void rotateDirectionToRightAndRight() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("rr");
		assertEquals(directionSouth,submarine.getDirection());
	}
	@Test public void goForwardEast() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionEast);
		submarine.communication("f");
		assertEquals(true, submarine.getPosition().equals(coordinateForwardEast));
	}
	@Test public void goForwardSouth() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionSouth);
		submarine.communication("f");
		assertEquals(true, submarine.getPosition().equals(coordinateForwardSouth));
	}
	@Test public void goForwardWest() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionWest);
		submarine.communication("f");
		assertEquals(true, submarine.getPosition().equals(coordinateForwardWest));
	}
	@Test public void goForwardNorth() {
		NemoSubmarine submarine = new NemoSubmarine(coordinateOrigin, directionNorth);
		submarine.communication("f");
		assertEquals(true, submarine.getPosition().equals(coordinateForwardNorth));
	}

}
