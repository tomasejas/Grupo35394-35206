package Line;

public class WinTypeA extends Win {
	private char letter;
	public WinTypeA(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	public boolean checkWin(Line game) {
		return game.winByHorizontal() || game.winByVertical();
	}
}
