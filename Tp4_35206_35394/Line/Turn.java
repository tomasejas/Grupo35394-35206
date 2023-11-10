package Line;

public abstract class Turn {
	public abstract void playAtRed(int column, Line game);
	public abstract void playAtBlue(int column, Line game);

	public abstract boolean isRedTurn();
}
