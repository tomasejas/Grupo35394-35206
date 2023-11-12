package Line;

public class BlueTurn extends Turn {

        public void playAtRed(int column, Line game) {
            throw new RuntimeException("Is not the red turn");
        }

        public void playAtBlue(int column, Line game) {
            if (column < 0 || column >= game.width) {
                throw new RuntimeException("Column out of bounds");
            }
            int row = game.checkRowForColumn(column);
            game.board.get(row).set(column, game.BLUE);
            game.turn = new RedTurn();
        }

    public boolean isRedTurn() {
        return false;
    }
}
