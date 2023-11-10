package Line;

public class WinTypeC extends Win {
	private char letter;
	public WinTypeC(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	public boolean checkWin(Line game) {
		return game.winByHorizontal() || game.winByVertical() || game.winByDiagonal();
	}
}
