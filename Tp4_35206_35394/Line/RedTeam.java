package Line;

public class RedTeam extends Team {
	@Override public void playAt(int column, Line game) {
		if (game.isRedTurn == false) throw new RuntimeException("Is not the red turn");
        int row = game.checkRowForColumn(column);
        game.board.get(row).set(column, Line.RED);
        game.isRedTurn = false;
	}
}
