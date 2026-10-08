package com.mycompany;

/**
 *Stores the board and game state for 2048.
 * 
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID insert student ID
 */
public class Game2048 {
    
    // TO DELETE COMMENT
    // Stores the board numbers and eventually handles movement, merging,
    // scoring and game rules.
    private final int[][] board;
    
    /**
     * Creates a new game with an empty board.
     */
    public Game2048() {
        board = new int[4][4];
    }
    
    /**
     * Returns the value stored at the specified board position.
     * 
     * @param row the row index of the cell
     * @param column the column index of the cell
     * @return the value stored in the cell
     */
    public int getCell(int row, int column) {
        return board[row][column];
    }
    
}
