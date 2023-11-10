package Line;

public class BlueTeam extends Team {
	@Override public void playAt(int column, Line game) {
		if (game.isRedTurn == true) throw new RuntimeException("Is not the blue turn");
        int row = game.checkRowForColumn(column);
        game.board.get(row).set(column, Line.BLUE);
        game.isRedTurn = true;
    }
}
