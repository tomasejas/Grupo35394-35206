package Line;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {
	private Line game;
	
	@Test public void alwaysStartsRed() {
		assertEquals(new Line(4,4, 'C').getTurn(), "red");
	}
	
	@Test public void alternateTurnsSuccesfuly() {
		game = new Line(4, 4, 'C');
		assertEquals(game.getTurn(), "red");
		game.playAtRed(0);
		assertEquals(game.getTurn(), "blue");
	}
	
	@Test public void cannotPlayIfIsntItTurn() {
		game = new Line(6, 6, 'C');
		game.playAtRed(0);
		assertThrowsLike( () -> game.playAtRed(0), "Is not the red turn." );
	}
	
	@Test public void redWinsVertical() {
		game = new Line(8, 5, 'A');
        redVerticalLine();
        assertTrue(game.finished());
    }

    @Test public void blueWinsHorizontal() {
    	game = new Line(4, 4, 'A');
        blueHorizontalLine();
        assertTrue(game.finished());
    }
    
    @Test public void redWinsDiagonal() {
    	game = new Line(6, 6, 'B');
    	redDiagonalLine();
    	assertTrue(game.finished());
    }
    
    @Test public void cannotWinByVerticalInTypeB() {
    	game = new Line(8, 5, 'B');
        redVerticalLine();
        assertFalse(game.finished());
    }
    
    @Test public void cannotWinByHorizontalInTypeB() {
    	game = new Line(4, 4, 'B');
        blueHorizontalLine();
        assertFalse(game.finished());
    }
    
    @Test public void cannotWinByDiagonalInTypeA() {
    	game = new Line(6, 6, 'A');
    	redDiagonalLine();
    	assertFalse(game.finished());
    }

    @Test public void gameDraw() {
    	game = new Line(1, 2, 'C');
        matchEndedInTwoMovements();
    }

    @Test public void invalidMovement() {
    	game = new Line(7, 1, 'C');
        matchEndedInTwoMovements();
    }
    
    private void assertThrowsLike ( Executable executable, String message) {
    	assertEquals( message,
    		assertThrows ( Exception.class, executable )
    		.getMessage() );
    }
    
    private void redVerticalLine() {
		game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        assertFalse(game.finished());
        game.playAtRed(0);
	}
    
    private void blueHorizontalLine() {
		game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(1);
        game.playAtBlue(2);
        game.playAtRed(2);
        game.playAtBlue(3);
        game.playAtRed(3);
        assertFalse(game.finished());
        game.playAtBlue(4);
	}
    
    private void redDiagonalLine() {
		game.playAtRed(0);
    	game.playAtBlue(1);
    	game.playAtRed(1);
    	game.playAtBlue(2);
    	game.playAtRed(2);
    	game.playAtBlue(3);
    	game.playAtRed(2);
    	game.playAtBlue(3);
    	game.playAtRed(3);
    	game.playAtBlue(0);
    	assertFalse(game.finished());
    	game.playAtRed(3);
	}
    
    private void matchEndedInTwoMovements() {
		game.playAtRed(0);
        assertFalse(game.finished());
        game.playAtBlue(0);
        assertTrue(game.finished());
	}
}
