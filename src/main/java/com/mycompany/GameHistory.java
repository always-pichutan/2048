package com.mycompany;

import java.util.Stack;

/**
 * Represents a 2048 tile with a rounded background.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID need to insert student ID
 */
public class GameHistory {

    public int[][] savedGame(int previousBoard[][], int board[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                previousBoard[i][j] = board[i][j];
            }
        }
        return previousBoard;
    }

    public boolean boardChanged(int[][] previousBoard, int[][] board) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (previousBoard[i][j] != board[i][j]) {
                    return true;
                }

            }
        }
        return false;
    }
    
    public int[][] undo(int[][] board, int[][] lastBoard) {
        //if undo button is pressed

        Stack<int[][]> undoStack = new Stack<>();

        //while Undo button is not pressed:
        undoStack.push(board);

        undoStack.pop();

        //when pressed
        lastBoard = undoStack.pop();

        return lastBoard;
    }
}