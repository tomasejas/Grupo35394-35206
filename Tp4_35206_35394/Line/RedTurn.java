package Line;

public class RedTurn extends Turn {

    public void playAtRed(int column, Line game) {
        int row = game.checkRowForColumn(column);
        game.board.get(row).set(column, game.RED);
        game.turn = new BlueTurn();
    }


    public void playAtBlue(int column, Line game) {
        throw new RuntimeException("Is not the blue turn");
    }

    public boolean isRedTurn() {
        return true;
    }

}
