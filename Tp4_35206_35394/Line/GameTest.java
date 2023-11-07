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
		game = new Line(4,4, 'C');
		assertEquals(game.getTurn(), "red");
	}
	
	@Test public void alternateTurns() {
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
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        assertFalse(game.checkWin('R', 3, 0));
        game.playAtRed(0);
        assertTrue(game.checkWin('R', 4, 0));
    }

    @Test public void blueWinsHorizontal() {
    	game = new Line(4, 4, 'A');
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(1);
        game.playAtBlue(2);
        game.playAtRed(2);
        game.playAtBlue(3);
        game.playAtRed(3);
        assertFalse(game.finished());
        game.playAtBlue(4);
        assertTrue(game.finished());
    }
    
    @Test public void redWinsDiagonal() {
    	game = new Line(6, 6, 'B');
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
    	assertTrue(game.finished());
    }
    
    @Test public void cannotWinByVerticalInTypeB() {
    	game = new Line(8, 5, 'A');
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        assertFalse(game.finished());
        game.playAtRed(0);
        assertFalse(game.finished());
    }
    
    @Test public void cannotWinByHorizontalInTypeB() {
    	game = new Line(4, 4, 'A');
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(1);
        game.playAtBlue(2);
        game.playAtRed(2);
        game.playAtBlue(3);
        game.playAtRed(3);
        assertFalse(game.finished());
        game.playAtBlue(4);
        assertFalse(game.finished());
    }
    
    @Test public void cannotWinByDiagonalInTypeA() {
    	game = new Line(6, 6, 'A');
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
    	assertFalse(game.finished());
    }

    @Test public void gameDraw() {
    	game = new Line(5, 6, 'A');
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(2);
        game.playAtBlue(3);
        game.playAtRed(4);
        game.playAtBlue(5);
        game.playAtBlue(6);
        game.playAtRed(6);
        game.playAtBlue(0);
        game.playAtRed(1);
        game.playAtBlue(2);
        game.playAtRed(3);
        game.playAtBlue(4);
        game.playAtRed(5);
        assertFalse(game.finished());
        game.playAtRed(6);
        assertTrue(game.finished());
    }

    @Test public void invalidMovement() {
    	game = new Line(7, 6, 'A');
        game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(0);
        game.playAtBlue(0);
        assertFalse(game.finished());
        game.playAtRed(0);
        assertTrue(game.finished());
    }
    
    private void assertThrowsLike ( Executable executable, String message) {
    	assertEquals( message,
    		assertThrows ( Exception.class, executable )
    		.getMessage() );
    }
}
