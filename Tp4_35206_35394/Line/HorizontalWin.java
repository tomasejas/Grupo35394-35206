package Line;

import java.util.List;

public class HorizontalWin extends Win {
	private Line game;
	public boolean checkWin(List<List<Character>> board, char player, int row, int column) {
        int count = 0;
        for (int c = 0; c < board.get(0).size(); c++) {
            if (board.get(row).get(c) == player) {
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
