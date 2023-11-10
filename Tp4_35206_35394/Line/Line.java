package Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    public List<List<Character>> board;
    private Win winVar;
    public int height;
    public int width;
    public static char RED = 'R';
    public static char BLUE = 'B';
    public boolean isRedTurn;

    public Line(int base, int height, Win winvariant) {
    	if (base < 4 || height < 4) throw new RuntimeException("Board size should be at least 4x4");
        this.board = new ArrayList<>(base);
        IntStream.range(0, base).forEach(i -> {
            List<Character> row = new ArrayList<>(height);
            IntStream.range(0, height).forEach(j -> row.add(' '));
            this.board.add(row);
        });

        this.winVar = winvariant;
        this.height = height;
        this.width = base;
        this.isRedTurn = true;
    }

    public String show() {
    	StringBuilder board = new StringBuilder();

        this.board.stream().forEach(row -> {
            board.append("|");
            row.stream().forEach(cell -> board.append(cell));
            board.append("|\n");
        });

        return board.toString();
    }

    public void playAt(int column, Team team) {

        if(!finished()) {
            team.playAt(column, this);
        } else {
            throw new RuntimeException("The game is finished");
        }

    }

    public boolean finished() {
    	return winVar.checkWin(this) || boardIsFull();
    }
    
    public boolean boardIsFull() {
        return this.board.stream()
                .flatMap(List::stream)
                .noneMatch(cell -> cell == ' ');
    }
    
    public boolean isRedTurn() {
        return isRedTurn;
    }
    
    public boolean redWon() {
        return winVar.checkWin(this) && !isRedTurn;
    }
    
    public boolean blueWon() {
    	return winVar.checkWin(this) && isRedTurn;
    }
    
    public int checkRowForColumn(int column) {
        int row = IntStream.range(0, this.height)
                .filter(i -> this.board.get(i).get(column) == ' ')
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("Column is full"));

        return row;
    }
    
    public boolean winByHorizontal() {
		return IntStream.range(0, this.height)
                .anyMatch(i -> IntStream.range(0, this.width - 3)
                        .anyMatch(j -> isHorizontalMatch(i, j)));
    }
	
	private boolean isHorizontalMatch(int i, int j ) {
        char cell = this.board.get(i).get(j);
        return cell != ' ' &&
                cell == this.board.get(i).get(j + 1) &&
                cell == this.board.get(i).get(j + 2) &&
                cell == this.board.get(i).get(j + 3);
    }
	
	boolean winByVertical() {
        return IntStream.range(0, this.height - 3)
                .anyMatch(i -> IntStream.range(0, this.width)
                        .anyMatch(j -> isVerticalMatch(i, j)));
    }

    private boolean isVerticalMatch(int i, int j) {
        char cell = this.board.get(i).get(j);
        return cell != ' ' &&
                cell == this.board.get(i + 1).get(j) &&
                cell == this.board.get(i + 2).get(j) &&
                cell == this.board.get(i + 3).get(j);
    }
    
    boolean winByDiagonal() {
        return IntStream.range(0, this.height - 3)
                .anyMatch(i -> IntStream.range(0, this.width - 3)
                        .anyMatch(j -> isDiagonalMatch(i, j) || isAntiDiagonalMatch(i, j)));
    }

    private boolean isDiagonalMatch(int i, int j) {
        char cell = this.board.get(i).get(j);
        return cell != ' ' &&
                cell == this.board.get(i + 1).get(j + 1) &&
                cell == this.board.get(i + 2).get(j + 2) &&
                cell == this.board.get(i + 3).get(j + 3);
    }
    
    private boolean isAntiDiagonalMatch(int i, int j) {
        char cell = this.board.get(i).get(j + 3);
        return cell != ' ' &&
                cell == this.board.get(i + 1).get(j + 2) &&
                cell == this.board.get(i + 2).get(j + 1) &&
                cell == this.board.get(i + 3).get(j);
    }
}