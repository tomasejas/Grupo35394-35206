package Line;

public class BlueTurn extends Turn {

        public void playAtRed(int column, Line game) {
            throw new RuntimeException("Is not the red turn");
        }

        public void playAtBlue(int column, Line game) {
            int row = game.checkRowForColumn(column);
            game.board.get(row).set(column, game.BLUE);
            game.turn = new RedTurn();
        }

    public boolean isRedTurn() {
        return false;
    }
}
