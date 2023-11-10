package Line;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GameTest {
	private Line game;
	
	@Test public void cannotCreateAnInvalidBoard() {
		assertThrowsLike( () -> new Line(3, 3, new winTypeC()), "Board size should be at least 4x4" );
	}
	
	@Test public void alwaysStartsRed() {
		assertTrue(new Line(4,4, new winTypeC()).isRedTurn());
	}
	
	@Test public void alternateTurnsSuccesfuly() {
		game = new Line(4, 4, new winTypeC());
		assertTrue(game.isRedTurn());
		game.playAt(0, new RedTeam());
		assertFalse(game.isRedTurn());
	}
	
	@Test public void cannotPlayIfIsntItTurn() {
		game = new Line(6, 6, new winTypeC());
		game.playAt(0, new RedTeam() );
		assertThrowsLike( () -> game.playAt(0, new RedTeam()), "Is not the red turn" );
	}
	
	@Test public void blueWinsVertical() {
		game = new Line(5, 5, new winTypeA());
		blueVerticalRow();
        assertTrue(game.finished());
        assertTrue(game.blueWon());
    }

    @Test public void redWinsHorizontal() {
    	game = new Line(4, 4, new winTypeA());
    	redHorizontalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }
    
    @Test public void redWinsDiagonal() {
    	game = new Line(6, 6, new winTypeB());
    	redDiagonalRow();
        assertTrue(game.finished());
        assertTrue(game.redWon());
    }
    
    @Test public void cannotWinByVerticalInTypeB() {
    	game = new Line(5, 5, new winTypeB());
		blueVerticalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }
    
    @Test public void cannotWinByHorizontalInTypeB() {
    	game = new Line(4, 4, new winTypeB());
    	redHorizontalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }
    
    @Test public void cannotWinByDiagonalInTypeA() {
    	game = new Line(5, 5, new winTypeA());
    	redDiagonalRow();
        assertFalse(game.finished());
        checkNoneTeamWon();
    }

    @Test public void gameDraw() {
    	game = new Line(4, 4, new winTypeA());
    	fillFirstTwoColumns();
        game.playAt(3, new RedTeam());
        game.playAt(2, new BlueTeam());
        game.playAt(2, new RedTeam());
        game.playAt(3, new BlueTeam());
        game.playAt(3, new RedTeam());
        game.playAt(2, new BlueTeam());
        game.playAt(2, new RedTeam());
        assertFalse(game.finished());
        game.playAt(3, new BlueTeam());
        assertTrue(game.finished());
        checkNoneTeamWon();
    }

    @Test public void invalidMovement() {
    	game = new Line(4, 4, new winTypeC());
    	fillFirstTwoColumns();
        assertFalse(game.finished());
		assertThrowsLike( () -> game.playAt(0, new RedTeam()), "Column is full" );
    }
    
    private void assertThrowsLike ( Executable executable, String message) {
    	assertEquals( message,
    		assertThrows ( Exception.class, executable )
    		.getMessage() );
    }
    
    private void redHorizontalRow() {
		game.playAt(0, new RedTeam());
        game.playAt(0, new BlueTeam());
        game.playAt(1, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(2, new RedTeam());
        game.playAt(2, new BlueTeam());
        assertFalse(game.finished());
        game.playAt(3, new RedTeam());
	}
    
    private void blueVerticalRow() {
		game.playAt(0, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(2, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(0, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(2, new RedTeam());
        assertFalse(game.finished());
        game.playAt(1, new BlueTeam());
	}
    
    private void redDiagonalRow() {
		game.playAt(0, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(1, new RedTeam());
        game.playAt(2, new BlueTeam());
        game.playAt(2, new RedTeam());
        game.playAt(3, new BlueTeam());
        game.playAt(2, new RedTeam());
        game.playAt(3, new BlueTeam());
        game.playAt(3, new RedTeam());
        game.playAt(0, new BlueTeam());
        assertFalse(game.finished());
        game.playAt(3, new RedTeam());
	}
    
    private void checkNoneTeamWon() {
		assertFalse(game.blueWon());
        assertFalse(game.redWon());
	}
    
    private void fillFirstTwoColumns() {
		game.playAt(0, new RedTeam());
        game.playAt(0, new BlueTeam());
        game.playAt(0, new RedTeam());
        game.playAt(0, new BlueTeam());
        game.playAt(1, new RedTeam());
        game.playAt(1, new BlueTeam());
        game.playAt(1, new RedTeam());
        game.playAt(1, new BlueTeam());
	}
}
