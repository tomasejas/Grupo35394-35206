package Line;

import java.util.List;

public class VerticalWin extends Win {
	public boolean checkWin(List<List<Character>> board, char player, int row, int column) {
        int count = 0;
        for (int r = 0; r < board.size(); r++) {
            if (board.get(r).get(column) == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
