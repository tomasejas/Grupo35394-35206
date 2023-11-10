package Line;

public class WinTypeB extends Win{
	private char letter;
	public WinTypeB(char letter) {
		this.letter = letter;
	}


	public char getLetter() {
		return letter;
	}

	public boolean checkWin(Line game) {
		return game.winByDiagonal();
	}
}
