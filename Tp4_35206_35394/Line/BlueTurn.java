package Line;

public class BlueTurn extends Turn {
    public static char BLUE = 'B';
    public void playAtRed(int column, Line game) {
            throw new RuntimeException("Is not the red turn");
    }
    public void playAtBlue(int column, Line game) {
        game.playAt(column, BLUE);
        game.turn = new RedTurn();
    }



    public boolean isRedTurn() {
        return false;
    }
}
