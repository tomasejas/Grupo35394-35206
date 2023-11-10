package Line;

public class winTypeB extends Win{
	public boolean checkWin(Line game) {
		return game.winByDiagonal();
	}
}
