package com.mycompany;

import java.util.Stack;

/**
 * Manages the history of previous 2048 game boards using a stack. Saves copies
 * of board states and restores them in last-in, first-out order when the player
 * uses Undo.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */
public class GameHistory {

    private final Stack<int[][]> undoStack = new Stack<>();
    private final Stack<Integer> scoreStack = new Stack<>();

    /**
     * Saves a copy of the current game board onto the Undo stack. Copies each
     * cell so later moves do not modify the saved state.
     *
     * @param board the game board to save
     * @param score the current score to save
     */
    public void savedBoard(int[][] board, int score) {
        int[][] copy = new int[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                copy[row][col] = board[row][col];
            }
        }

        undoStack.push(copy);
        scoreStack.push(score);
    }

    /**
     * Removes and returns the most recently saved board from the Undo stack.
     *
     * @return the previous board state, or null if the stack is empty
     */
    public int[][] undo() {
        if (undoStack.isEmpty()) {
            return null;
        }

        return undoStack.pop();
    }

    /**
     * Removes and returns the most recently saved score.
     *
     * @return the previous score, or null if no score is saved
     */
    public Integer undoScore() {
        if (scoreStack.isEmpty()) {
            return null;
        }

        return scoreStack.pop();
    }

    /**
     * Removes the most recently saved board and score from the Undo stack. Does
     * nothing if the stack is empty. Used when a move does not change the
     * board.
     */
    public void discardLastSave() {
        if (!undoStack.isEmpty()) {
            undoStack.pop();
            scoreStack.pop();
        }
    }
}
