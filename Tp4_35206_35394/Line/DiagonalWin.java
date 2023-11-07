package Line;

public class DiagonalWin extends Win {
	private Line game;
	public boolean checkWin(char[][] board, char player, int row, int column) {
        int count = 0;
        for (int r = row, c = column; r < board.length && c < board[0].length; r++, c++) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    game.setWin();
                }
            } else {
                count = 0;
            }
        }

        // Verificar victoria en diagonal ascendente (/)
        count = 0;
        for (int r = row, c = column; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true; // 4 en línea en diagonal ascendente
                }
            } else {
                count = 0; // Restablecer el contador
            }
        }

        return false; // No se encontró una victoria en diagonal
    }
}
