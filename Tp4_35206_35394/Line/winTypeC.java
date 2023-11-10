package Line;

public class winTypeC extends Win {
	public boolean checkWin(Line game) {
		return game.winByHorizontal() || game.winByVertical() || game.winByDiagonal();
	}
}
