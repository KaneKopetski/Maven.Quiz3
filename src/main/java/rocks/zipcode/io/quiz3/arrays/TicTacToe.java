package rocks.zipcode.io.quiz3.arrays;

import java.util.Arrays;

/**
 * @author leon on 09/12/2018.
 */
public class TicTacToe {
    String[][] board;

    public TicTacToe(String[][] board) {
        this.board = board;
    }

    public TicTacToe() {

    }

    public String[] getRow(Integer value) {
        return this.board[value];
    }

    public String[] getColumn(Integer value) {
        String[] column = new String[3];
        for (int i = 0; i < 3; i++) {
            column[i] = this.board[i][value];
        }
        return column;
    }

    public Boolean isRowHomogenous(Integer rowIndex) {
        String[] row = getRow(rowIndex);
        return Arrays.stream(row).allMatch(row[0]::equals);

    }

    public Boolean isColumnHomogeneous(Integer columnIndex) {
        String[] column = getColumn(columnIndex);
        return Arrays.stream(column).allMatch(column[0]::equals);
    }

    public String getWinner() {
        for (int i = 0; i < 3; i++) {
            if (isColumnHomogeneous(i)) {
                return getColumn(i)[0];
            }
            else if (isRowHomogenous(i)) {
                return getRow(i)[0];
            }
            else if (this.board[0][0].equals(this.board[1][1]) &&  this.board[0][0].equals(this.board[2][2]) ||
                    this.board[0][2].equals(this.board[1][1]) &&  this.board[1][1].equals(this.board[2][0])) {
                return this.board[1][1];
            }

        }
        return null;
    }

    public String[][] getBoard() {
        return this.board;
    }
}
