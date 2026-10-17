package com.mycompany;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generates new tiles at random empty positions on a 2048 game board.
 * Each generated tile has a value of 2 or 4.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */
public class TileGenerator {
    
    /**
     * Generates a tile in a randomly selected empty cell of the board.
     * The tile has a 90% chance of being 2 and a 10% chance of being 4.
     * Leaves the board unchanged if no empty cells are available.
     * 
     * @param board the game board in which to generate a tile
     */
    public void generateTile(int[][] board) {

        ArrayList<int[]> emptyCells = new ArrayList<>();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

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
        int[] selectedCell = emptyCells.get(randomIndex);
        
        int value = chooseTileValue(randomGenerator);

        board[selectedCell[0]][selectedCell[1]] = value;

    }
    
    private int chooseTileValue(Random randomGenerator) {
        double probability = randomGenerator.nextDouble();
        
        if (probability <= 0.9) {
            return 2;
        } else {
            return 4;
        }
    }
}