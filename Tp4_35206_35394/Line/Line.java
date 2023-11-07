package Line;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<List<Character>> board;
    private char winVariant;
    private String turn;
    private boolean isOver;
    private Win horizontalWin;
    private Win verticalWin;
    private Win diagonalWin;

    public Line(int base, int height, char winVariant) {
        this.board = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Character> row = new ArrayList<>();
            for (int j = 0; j < base; j++) {
                row.add(null);
            }
            board.add(row);
        }

        this.turn = "red";
        this.winVariant = winVariant;
        this.isOver = false;
    }
	
	private void redTurn() {
		this.turn = "red";
	}
	
	private void blueTurn() {
		this.turn = "blue";
	}
	
	public String getTurn() {
		return this.turn;
	}

    public String show() {
        StringBuilder display = new StringBuilder();
        for (int i = board.size() - 1; i >= 0; i--) {
            for (int j = 0; j < board.get(i).size(); j++) {
                display.append(board.get(i).get(j) == null ? '-' : board.get(i).get(j));
                display.append(' ');
            }
            display.append('\n');
        }
        return display.toString();
    }

    public void playAtRed(int column) {
        play(column, 'R');
        blueTurn();
    }

    public void playAtBlue(int column) {
        play(column, 'B');
        redTurn();
    }

    private void play(int column, char color) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(column) == null) {
                board.get(i).set(column, color);
                break;
            }
        }
    }

    public boolean finished() {
        return this.isOver; 
    }
    
    public void setWin() {
    	this.isOver = true;
    }
    
    public boolean checkWin(char player, int row, int column) {
        if (this.winVariant == 'A') {
            return horizontalWin.checkWin(board, player, row, column) || verticalWin.checkWin(board, player, row, column);
        } else if (this.winVariant == 'B') {
            return diagonalWin.checkWin(board, player, row, column);
        } else if (this.winVariant == 'C') {
            return horizontalWin.checkWin(board, player, row, column) || verticalWin.checkWin(board, player, row, column) || diagonalWin.checkWin(board, player, row, column);
        }
        return false;
    }
    
    public void setBoard(List<List<Character>> newBoard) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(0).size(); j++) {
                board.get(i).set(j, newBoard.get(i).get(j));
            }
        }
    }
}