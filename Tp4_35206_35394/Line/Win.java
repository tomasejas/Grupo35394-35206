package Line;

import java.util.List;

public abstract class Win {
	public abstract boolean checkWin(List<List<Character>> board, char player, int row, int column);
}
