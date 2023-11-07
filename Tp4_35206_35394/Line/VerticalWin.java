package Line;

import java.util.List;

public class VerticalWin extends Win {
	private Line game;
	public boolean checkWin(List<List<Character>> board, char player, int row, int column) {
        int count = 0;
        for (int r = 0; r < board.size(); r++) {
            if (board.get(r).get(column) == player) {
                count++;
                if (count == 4) {
                    game.setWin();
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
