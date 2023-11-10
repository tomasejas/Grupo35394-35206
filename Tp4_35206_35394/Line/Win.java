package Line;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Win {

	public static ArrayList<Win> winTypes = new ArrayList<>(
			Arrays.asList(
					new WinTypeA('A'),
					new WinTypeB('B'),
					new WinTypeC('C')));
	public static Win getWinVariant(char winVariant) {
		return winTypes.stream().filter(winType -> winType.getLetter() == winVariant).findFirst().orElse(null);
	}

	public abstract char getLetter();
	public abstract boolean checkWin(Line game);
}
