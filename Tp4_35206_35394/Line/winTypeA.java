package Line;

public class winTypeA extends Win {
	public boolean checkWin(Line game) {
		return game.winByHorizontal() || game.winByVertical();
	}
}
