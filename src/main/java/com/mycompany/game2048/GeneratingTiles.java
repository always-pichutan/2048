package com.mycompany.game2048;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GeneratingTiles {
    
    public int[][] savedGame (int previousBoard[][], int board[][]) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++){
                previousBoard[i][j] = board[i][j];
            }
        }
        return previousBoard;
    }
    
    public void generateTile(int board[][], boolean changed) {
        
        ArrayList<int[]> emptyCells = new ArrayList<>();
        
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++){
                
                if (board[row][col] == 0) {
                   emptyCells.add(new int[]{row, col});
                } 
            }
        }
        
        if (emptyCells.isEmpty()) {
            return;
        }
        
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(emptyCells.size());
        int [] selectedCell = emptyCells.get(randomIndex);
        int value;
        
        double probability = randomGenerator.nextDouble();
        if (probability <= 0.9) {
            value = 2;
        } else {
            value = 4;
        }
        
        board[selectedCell[0]][selectedCell[1]] = value;
        
    }
    
    public boolean boardChanged (int[][] previousBoard, int[][] board) {
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (previousBoard[i][j] != board[i][j]) {
                    return true;
                } 
                
            }
        }
        return false;
    }

    public boolean detectGameOver(int[] emptyCells, boolean change) {
        return emptyCells.length == 0 && change;
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
