package Line;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<List<Character>> board;
    private char winVariant;
    private boolean redTurn;

    public Line(int base, int altura, char winVariant) {
        this.board = new ArrayList<>();
        for (int i = 0; i < altura; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < base; j++) {
                row.add(null);
            }
            board.add(row);
        }

        this.winVariant = winVariant;
        this.redTurn = true;
    }

    public String show() {
        StringBuilder display = new StringBuilder();
        for (int i = board.size() - 1; i >= 0; i--) {
            for (int j = 0; j < board.get(i).size(); j++) {
                display.append(board.get(i).get(j) == null ? '-' : board.get(i).get(j));
                display.append(' ');
            }
            display.append('\n');
        }
        return display.toString();
    }

    public void playRedkAt(int column) {
        play(column, 'R');
        redTurn = false;
    }

    public void playBlueAt(int column) {
        play(column, 'B');
        redTurn = true;
    }

    private void play(int column, char color) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(column) == null) {
                board.get(i).set(column, color);
                break;
            }
        }
    }


    public boolean finished() {
        // Implementar lógica para determinar si el juego ha terminado
        return false; // Placeholder, debes completar esta parte
    }
}
