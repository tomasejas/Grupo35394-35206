package Line;

public class RedTurn extends Turn {

    public static char RED = 'R';
    public void playAtRed(int column, Line game) {
        game.playAt(column, RED);
        game.turn = new BlueTurn();
    }


    public void playAtBlue(int column, Line game) {
        throw new RuntimeException("Is not the blue turn");
    }

    public boolean isRedTurn() {
        return true;
    }

}
