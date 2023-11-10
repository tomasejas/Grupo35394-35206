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
    protected Turn turn;

    public Line(int base, int height, char winvariant) {

        this.board = new ArrayList<>(base);
        IntStream.range(0, base).forEach(i -> {
            List<Character> row = new ArrayList<>(height);
            IntStream.range(0, height).forEach(j -> row.add(' '));
            this.board.add(row);
        });

        this.winVar = Win.getWinVariant(winvariant);
        this.height = height;
        this.width = base;
        this.turn = new RedTurn();
    }

    public String show() {
    	StringBuilder board = new StringBuilder();

        this.board.stream().forEach(row -> {
            board.append("|");
            row.stream().forEach(cell -> board.append(cell));
            board.append("|\n");
        });

        return board.toString();
        // completar show con anuncio de quien le toca jugar y quien gano o si fue empate
        // hacer test checkenado si gano rojo gano azul o empate
        // hacer test si se trata de poner en una columna fuera de rango y implementar el error en el codigo
    }

    public void playAtRed(int column) {

        if(!finished()) {
            turn.playAtRed(column, this);
        } else {
            throw new RuntimeException("The game is finished");
        }

    }

    public void playAtBlue(int column) {

        if(!finished()) {
            turn.playAtBlue(column, this);
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
    

    
    public boolean redWon() {
        return winVar.checkWin(this) && !turn.isRedTurn();
    }
    
    public boolean blueWon() {
    	return winVar.checkWin(this) && turn.isRedTurn();
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