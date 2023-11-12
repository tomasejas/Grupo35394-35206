package Line;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {
	private Line game;
	
	@Test public void gameIsntFinishedAtStart() {
        game = new Line(4, 4, 'C');
        assertFalse(game.finished());
    }


	@Test public void alwaysStartsRed() {
		assertTrue(new Line(4,4, 'C').turn.isRedTurn());
	}
	
	@Test public void alternateTurnsSuccesfuly() {
		game = new Line(4, 4, 'C');
		assertTrue(game.turn.isRedTurn());
		game.playAtRed(0);
		assertFalse(game.turn.isRedTurn());
	}
	
	@Test public void cannotPlayIfIsntItTurn() {
		game = new Line(6, 6, 'C');
		game.playAtRed(0);
		assertThrowsLike( () -> game.playAtRed(0), "Is not the red turn" );
	}
    @Test public void blueDoesNotPlaysFirst() {
        game = new Line(4, 4, 'C');
        assertTrue(game.turn.isRedTurn());
        assertThrowsLike( () -> game.playAtBlue(0), "Is not the blue turn");
        game.playAtRed(0);
        assertFalse(game.turn.isRedTurn());
    }
	
	@Test public void blueWinsVertical() {
		game = new Line(5, 5, 'A');
		blueVerticalRow();
        assertTrue(game.finished());
        assertTrue(game.blueWon());
    }

    @Test public void redWinsHorizontal() {
    	game = new Line(4, 4, 'A');
    	redHorizontalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }
    
    @Test public void redWinsDiagonal() {
    	game = new Line(6, 6, 'B');
    	redDiagonalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }
    
    @Test public void cannotWinByVerticalInTypeB() {
    	game = new Line(5, 5, 'B');
		blueVerticalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }

    @Test public void cannotWinByHorizontalInTypeB() {
    	game = new Line(4, 4, 'B');
    	redHorizontalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }
    
    @Test public void cannotWinByDiagonalInTypeA() {
    	game = new Line(5, 5, 'A');
    	redDiagonalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }

    @Test public void WinByDiagonalInTypeC() {
    	game = new Line(5, 5, 'C');
        redDiagonalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }
    @Test public void WinByVerticalInTypeC() {
    	game = new Line(5, 5, 'C');
        blueVerticalRow();
        assertTrue(game.finished());
        assertTrue(game.blueWon());
    }

    @Test public void WinByHorizontalInTypeC() {
    	game = new Line(4, 4, 'C');
        redHorizontalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }

    @Test public void tiedGame() {
    	game = new Line(4, 4, 'A');
    	fillFirstFourColumnsInATie();
        assertTrue(game.finished());
        checkNoneTeamWon();
    }

    @Test public void invalidMoveFullColumn() {
    	game = new Line(4, 4, 'C');
    	fillFirstTwoColumnsInATie();
        assertFalse(game.finished());
		assertThrowsLike( () -> game.playAtRed(0), game.ColumnIsFull );
        game.playAtRed(2);
        assertThrowsLike( () -> game.playAtBlue(1), game.ColumnIsFull );
    }

    @Test public void invalidMoveFinishedGame() {
    	game = new Line(4, 4, 'C');
    	fillFirstFourColumnsInATie();
        assertTrue(game.finished());
        assertThrowsLike( () -> game.playAtRed(0), game.TheGameIsFinished );
        assertThrowsLike( () -> game.playAtBlue(1), game.TheGameIsFinished );
    }

    @Test public void invalidMoveColumnOutOfBounds() {
    	game = new Line(4, 4, 'C');
    	assertThrowsLike( () -> game.playAtRed(-1), game.ColumnOutOfBounds );
    	assertThrowsLike( () -> game.playAtRed(4), game.ColumnOutOfBounds );
    }
    
    private void assertThrowsLike ( Executable executable, String message) {
    	assertEquals( message,
    		assertThrows ( Exception.class, executable )
    		.getMessage() );
    }
    
    private void redHorizontalRow() {
		game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(1);
        game.playAtBlue(1);
        game.playAtRed(2);
        game.playAtBlue(2);
        game.playAtRed(3);
	}
    
    private void blueVerticalRow() {
		game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(2);
        game.playAtBlue(1);
        game.playAtRed(0);
        game.playAtBlue(1);
        game.playAtRed(2);
        game.playAtBlue(1);
	}
    
    private void redDiagonalRow() {
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
        game.playAtRed(3);
	}
    
    private void checkNoneTeamWon() {
		assertFalse(game.blueWon());
        assertFalse(game.redWon());
	}

    private void fillFirstTwoColumnsInATie() {
		game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(1);
        game.playAtBlue(1);
        game.playAtRed(1);
        game.playAtBlue(1);
	}
    private void fillFirstFourColumnsInATie(){
        game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(0);
        game.playAtBlue(0);
        game.playAtRed(1);
        game.playAtBlue(1);
        game.playAtRed(1);
        game.playAtBlue(1);
        game.playAtRed(3);
        game.playAtBlue(2);
        game.playAtRed(2);
        game.playAtBlue(3);
        game.playAtRed(3);
        game.playAtBlue(2);
        game.playAtRed(2);
        game.playAtBlue(3);
    }

}
